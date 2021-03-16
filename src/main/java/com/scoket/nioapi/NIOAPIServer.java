package com.scoket.nioapi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author yds
 * @title: NIOAPIServer
 * @description: TODO
 * @date 2021/2/25 18:03
 */
public class NIOAPIServer {

    private Selector selector;


    public static void main(String[] args) throws Exception {
        NIOAPIServer nioapiServer = new NIOAPIServer();
        nioapiServer.initServer(8080);
        nioapiServer.listen();
    }


    private  void initServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }


    public void listen() throws IOException {
        while (true){
            int select = selector.select(0);
            if(select == 0){
                continue;
            }

            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                iterator.remove();

                if(next.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel)next.channel();
                    SocketChannel accept = channel.accept();
                    channel.configureBlocking(false);

                    channel.register(selector,SelectionKey.OP_READ);
                }else if(next.isReadable()){
                    ready(next);
                }
            }
        }
    }

    private void ready(SelectionKey next) throws IOException {
        SocketChannel channel = (SocketChannel)next.channel();
        ByteBuffer allocate = ByteBuffer.allocate(512);
        int read = channel.read(allocate);

        byte[] array = allocate.array();
        String s = new String(array);
        System.out.println(channel.getRemoteAddress() + ":" + s);

        Scanner scanner = new Scanner(System.in);
        ByteBuffer wrap = ByteBuffer.wrap(scanner.nextLine().getBytes("utf-8"));
        channel.write(wrap);
    }
}
