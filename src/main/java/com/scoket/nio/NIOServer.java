package com.scoket.nio;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yds
 * @title: NIOSever
 * @description: TODO
 * @date 2021/2/25 16:12
 */
public class NIOServer {
    static ByteBuffer buf = ByteBuffer.allocate(512);
    static List<SocketChannel> socketChannelList = new ArrayList<SocketChannel>();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        System.out.println("服务端已启动...");
        System.out.println("-------------------------------------------");

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel != null) {
                socketChannel.configureBlocking(false);
                socketChannelList.add(socketChannel);
                System.out.println(socketChannel + "加入直播间");
            }

            // 一个线程维护多个线程
            Iterator it = socketChannelList.iterator();
            while(it.hasNext()){
                SocketChannel scl = (SocketChannel)it.next();
                int read = scl.read(buf);
                if(read > 0){
                    buf.flip();

                    Charset charset = Charset.forName("UTF-8");
                    String string = charset.newDecoder().decode(buf.asReadOnlyBuffer()).toString();

//                    byte[] array = buf.array();
//                    String string = new String(array);
                    System.out.println(scl.getRemoteAddress() + ":" + string);

                    buf.clear();


                    ByteBuffer wrap = ByteBuffer.wrap("我是服务端，已收到你的消息，请耐心等待...\r\n".getBytes("utf-8"));
                    scl.write(wrap);

//                    it.remove();
                }

            }
        }
    }
}
