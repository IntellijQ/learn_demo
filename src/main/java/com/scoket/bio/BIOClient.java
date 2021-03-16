package com.scoket.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author yds
 * @title: BIOClient
 * @description: TODO
 * @date 2021/2/25 10:44
 */
public class BIOClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8080);
        socket.connect(socketAddress);

        String clientRequest =  "你好，我们能做朋友么？";
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
        socketOut.write(clientRequest);
        socketOut.write("\r\n");
        socketOut.flush();

        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String severResponse = socketIn.readLine();
        System.out.println("服务端说：" + severResponse);

        socketOut.close();
        socketIn.close();
        socket.close();



    }
}
