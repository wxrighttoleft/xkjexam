package com.zyexam.services;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class WebSocketServer {
	private final int port;  
    public static ChannelGroup recipients = new DefaultChannelGroup();
      
    public WebSocketServer(int port) {  
        this.port = port;  
    }  
  
    public void run() {  
        // Configure the server.  
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(  
                Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));  
  
        // Set up the event pipeline factory.  
        bootstrap.setPipelineFactory(new WebSocketServerPipelineFactory());  
  
        // Bind and start to accept incoming connections.  
        bootstrap.bind(new InetSocketAddress(port));  
  
    }
}
