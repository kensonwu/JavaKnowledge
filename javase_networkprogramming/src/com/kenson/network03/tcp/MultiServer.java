package com.kenson.network03.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 模拟服务器程序接受客户端发来的信息，同时响应客户端信息
 * @author: Kenson
 * @date: 2020/9/25
 */
public class MultiServer {
    public static void main(String[] args) {
            DataOutputStream dos = null;
            DataInputStream dis = null;
        try {
            // 服务端接收客户端发送来的数据
            // 创建服务端Socket
            ServerSocket serverSocket = new ServerSocket(8888);
            // 服务端接收客户端请求
            Socket accept = serverSocket.accept();
            // 使用DataInputStream接收客户端的消息
            dis = new DataInputStream(accept.getInputStream());
            String clientMsg = dis.readUTF();
            System.out.println("客户端发送过来的数据为：" + clientMsg);

            // 服务端响应客户端的信息
            // 使用DataOutputStream响应客户端的消息
            dos = new DataOutputStream(accept.getOutputStream());
            dos.writeUTF("客户端你好， 这是我对你的响应信息！");

//            dos.close();
//            dis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
