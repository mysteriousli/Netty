//package com.example.netty.netty.chat;
//
//import io.netty.channel.ChannelHandler;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandler;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//import io.netty.handler.codec.http.DefaultFullHttpResponse;
//import io.netty.handler.codec.http.FullHttpRequest;
//import io.netty.handler.codec.http.HttpResponseStatus;
//import io.netty.handler.codec.http.HttpVersion;
//import org.springframework.stereotype.Component;
//
//@Component
//@ChannelHandler.Sharable
//public class WebSocketHandler extends ChannelInboundHandlerAdapter {
//
//    @Override
//    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
//
//    }
//
//    @Override
//    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
//
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
//
//    }
//
//    @Override
//    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
//
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
//        if (o instanceof FullHttpRequest){
//            FullHttpRequest request = (FullHttpRequest) o;
//            if (!request.decoderResult().isSuccess() || "websocket".equals(request.headers().get("Upgrade"))){
//                DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST);
//
//            }
//
//        }
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
//
//    }
//
//    @Override
//    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
//
//    }
//
//    @Override
//    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
//
//    }
//
//    @Override
//    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
//
//    }
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
//
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
//
//    }
//}
