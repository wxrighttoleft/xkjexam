package com.zyexam.services;

import java.util.Iterator;

import net.sf.json.JSONObject;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import org.jboss.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.jboss.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.jboss.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import org.jboss.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.zyexam.util.Message;


public class WebSocketServerHandler extends SimpleChannelUpstreamHandler {
	@SuppressWarnings("unused")
	private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocketServerHandler.class);  
	  
    private static final String WEBSOCKET_PATH = "/websocket";  
  
    private WebSocketServerHandshaker handshaker;  
  
    @Override  
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {  
        Object msg = e.getMessage();  
        if (msg instanceof HttpRequest) {  
            handleHttpRequest(ctx, (HttpRequest) msg);  
        } else if (msg instanceof WebSocketFrame) {  
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);  
        }
    }  
  
    private void handleHttpRequest(ChannelHandlerContext ctx, HttpRequest req) throws Exception {  
  
        // Handshake  
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(  
                getWebSocketLocation(req), null, false);  
        handshaker = wsFactory.newHandshaker(req);  
        if (handshaker == null) {  
            wsFactory.sendUnsupportedWebSocketVersionResponse(ctx.getChannel());  
        } else {  
            handshaker.handshake(ctx.getChannel(), req).addListener(WebSocketServerHandshaker.HANDSHAKE_LISTENER);  
        }  
          
        WebSocketServer.recipients.add(ctx.getChannel());
    }  
  
    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {  
  
        // Check for closing frame  
        if (frame instanceof CloseWebSocketFrame) {  
            handshaker.close(ctx.getChannel(), (CloseWebSocketFrame) frame);  
              
            WebSocketServer.recipients.clear();  
            return;  
        }
        // 处理接受到的数据（转成大写）并返回  
        String request = ((TextWebSocketFrame) frame).getText();  
//        if (logger.isDebugEnabled()) {  
//            logger.debug(String.format("Channel %s received %s", ctx.getChannel().getId(), request));  
//        }  
        WebSocketServer.recipients.write(new TextWebSocketFrame(request));
        String appurl = WebSocketServerHandler.class.getResource("/").toString();
        ApplicationContext app = new FileSystemXmlApplicationContext(appurl + "/applicationContext.xml");
        ExamUserServer eus = (ExamUserServer)app.getBean("examUserServer");
        JSONObject jsonobj = JSONObject.fromObject(request);
        Message msg = (Message)JSONObject.toBean(jsonobj, Message.class);
        System.out.println(msg.getId());
    }  
      
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {  
        e.getCause().printStackTrace();  
        e.getChannel().close();
        for(Iterator<Channel> itr = WebSocketServer.recipients.iterator();itr.hasNext();){
        	Channel channel = itr.next();
        	if(ctx.getChannel().getId() == channel.getId()){
        		channel.close();
        		break;
        	}
        }
    }  
  
    @SuppressWarnings("deprecation")
	private static String getWebSocketLocation(HttpRequest req) {  
        return "ws://" + req.getHeader(HttpHeaders.Names.HOST) + WEBSOCKET_PATH;  
    }
}
