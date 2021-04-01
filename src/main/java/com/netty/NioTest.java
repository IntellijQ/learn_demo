package com.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yds
 * @title: NioTest
 * @description: TODO
 * @date 2021/3/31 14:42
 */
public class NioTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9090));
        serverSocket.configureBlocking(false);

        // 打开Selector处理channel，即创建epoll
        Selector selector = Selector.open();
        // 为服务端注册接受连接事件
        SelectionKey serverkey = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(serverkey + "服务端已启动。。。");

        while (true) {
            // 阻塞等待需要处理的事件发生
            selector.select();

            // 获取selector中注册的全部活跃事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 服务端接受连接事件，则将客户端channel进行注册
                if (selectionKey.isAcceptable()) {
                    // 获取当前服务端连接
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    // 建立客户端
                    SocketChannel clientSocket = server.accept();
                    clientSocket.configureBlocking(false);
                    // 注册客户端读事件
                    SelectionKey clientKey = clientSocket.register(selector, SelectionKey.OP_READ);
                    System.out.println(clientKey + "客户端 已上线");

                } else if (selectionKey.isReadable()) {
                    // 获取当前客户端连接
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    int read = socketChannel.read(allocate);
                    if(read > 0){
                        System.out.println("收到" + selectionKey + "消息：" + new String(allocate.array()));
                    }else if(read == -1){
                        System.out.println(selectionKey + "客户端 已下线");
                        socketChannel.close();
                    }
                }
                iterator.remove();
            }
        }
    }
}
