package com.zyexam.web.action;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;

public class WebSocketServerPipelineFactory implements ChannelPipelineFactory {

	public ChannelPipeline getPipeline() throws Exception {
		// // pipeline 的配置与 逻辑  
        ChannelPipeline pipeline = Channels.pipeline();  
        pipeline.addLast("decoder", new HttpRequestDecoder());  
        pipeline.addLast("aggregator", new HttpChunkAggregator(65536));  
        pipeline.addLast("encoder", new HttpResponseEncoder());  
        pipeline.addLast("handler", new WebSocketServerHandler());  
        return pipeline; 
	}

}
