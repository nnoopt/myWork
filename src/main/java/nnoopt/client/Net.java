package nnoopt.client;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//public class Net {
//
//    private SocketChannel channel;
//    private OnReceived callback;
//
//    public Net(OnReceived callback){
//        this.callback = callback;
//        new Thread(()->{
//            EventLoopGroup group = new NioEventLoopGroup();
//
//            try {
//                Bootstrap bootstrap = new Bootstrap();
//                ChannelFuture future = bootstrap.channel(NioSocketChannel.class)
//                        .group(group)
//                        .handler(new ChannelInitializer<SocketChannel>() {
//                            @Override
//                            protected void initChannel(SocketChannel ch) throws Exception {
//                                channel = ch;
//                                ch.pipeline().addLast(
//                                        new ObjectEncoder(),
//                                        new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
//                                        new ClientMessageHandler(callback)
//                                );
//                            }
//                        }).connect("localhost", 8189).sync();
//
//                future.channel().closeFuture().sync();
//            }catch (Exception e){
//                log.debug("e= ", e);
//
//            }finally {
//                group.shutdownGracefully();
//
//            }
//        }).start();
//    }
//
//    public void sendMessage(AbstractMessage message){
//        channel.writeAndFlush(message);
//    }
//}
