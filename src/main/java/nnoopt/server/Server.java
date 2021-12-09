package nnoopt.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//public class Server {
//    public static void main(String[] args) {
//        EventLoopGroup auth = new NioEventLoopGroup(1);
//        EventLoopGroup worker = new NioEventLoopGroup();
//
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            ChannelFuture future = serverBootstrap.group(auth, worker).channel(NioServerSocketChannel.class)
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel channel) throws Exception {
//                            channel.pipeline().addLast(
//                                            new StringDecoder(),
//                                            new StringEncoder(),
//                                            new StringHandler());
//                        }
//                    }).bind(8189).sync();
//            log.debug("Server started");
//            future.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            log.error("e=", e);
//        } finally {
//            auth.shutdownGracefully();
//            worker.shutdownGracefully();
//        }
//
//    }
//}

