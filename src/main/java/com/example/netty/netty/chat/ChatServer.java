//package com.example.netty.netty.chat;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelHandler;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.handler.codec.http.HttpObjectAggregator;
//import io.netty.handler.codec.http.HttpServerCodec;
//import io.netty.handler.stream.ChunkedWriteHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//@Configuration
//public class ChatServer {
//    @Bean
//    public NioEventLoopGroup bossGroup(){
//        return new NioEventLoopGroup();
//    }
//    @Bean
//    public NioEventLoopGroup workerGroup(){
//        return new NioEventLoopGroup();
//    }
//    @Bean
//    public ServerBootstrap bootstrap(){
//        ServerBootstrap serverBootstrap = new ServerBootstrap();
//        serverBootstrap.group(bossGroup(),workerGroup())
//                .channel(NioServerSocketChannel.class)
//                .childHandler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        socketChannel.pipeline().addLast(new HttpServerCodec());
//                        socketChannel.pipeline().addLast(new ChunkedWriteHandler());
//                        socketChannel.pipeline().addLast(new HttpObjectAggregator(65536));
//                    }
//                })
//                .option(ChannelOption.SO_BACKLOG,100)
//                .childOption(ChannelOption.SO_KEEPALIVE, true);
//        return serverBootstrap;
//    }
//}
