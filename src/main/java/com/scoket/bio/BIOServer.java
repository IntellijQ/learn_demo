package com.scoket.bio;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * @author yds
 * @title: BIOServer
 * @description: TODO
 * @date 2021/2/25 10:43
 */
public class BIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8080);
        serverSocket.bind(socketAddress);

        System.out.println("服务端已启动...");
        System.out.println("-------------------------------------------");

        while(true){
            Socket socket = serverSocket.accept();
            System.out.println(socket.getRemoteSocketAddress() + "加入直播间");

//            byte[] buff = new byte[1024];
//            if(socket.getInputStream().read(buff) > 0){
//                System.out.println("客户端说：" + new String(buff));
//            }

            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String severResponse = socketIn.readLine();
            System.out.println("客户端说：" + severResponse);

            PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
            socketOut.write("好");
            socketOut.write("\r\n");

            socketOut.close();
            socket.close();
        }
    }
}
