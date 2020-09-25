package com.kenson.network03.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 模拟服务器程序
 * 场景为： 服务器端接收客户端发送过来的信息
 * 该服务器只能接受一次客户端的请求
 * @author: Kenson
 * @date: 2020/9/25
 */
public class OnetimeServer {
    public static void main(String[] args) {
        try {
            // 创建服务端Socket
            ServerSocket server = new ServerSocket(8888);
            // 服务器接收请求
            Socket accept = server.accept();
            // 获取客户端发送过来的数据
            // 使用DataInputStream
            DataInputStream dis = new DataInputStream(accept.getInputStream());
            String recMsg = dis.readUTF();
            System.out.println(recMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
