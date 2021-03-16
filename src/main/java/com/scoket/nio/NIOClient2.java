package com.scoket.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @author yds
 * @title: NIOClient
 * @description: TODO
 * @date 2021/2/25 16:33
 */
public class NIOClient2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        SocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8080);
        socket.connect(inetSocketAddress);
        System.out.println("客户端1已启动...");
        System.out.println("-------------------------------------------");

        while (true){
            Scanner scanner = new Scanner(System.in);
//            socket.getOutputStream().write(scanner.next().getBytes());
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
            socketOut.write(scanner.next());
//            socketOut.write("\r\n");
            socketOut.flush();

            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String severResponse = socketIn.readLine();
            System.out.println(severResponse);
        }
    }
}
