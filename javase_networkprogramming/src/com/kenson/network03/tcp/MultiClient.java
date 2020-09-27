package com.kenson.network03.tcp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @description: 模拟客户端发送消息 同时接受服务发送过来的信息
 * @author: Kenson
 * @date: 2020/9/25
 */
public class MultiClient {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        DataInputStream dis = null;
        try {
            // 创建Socket对象，包含服务器地址以及端口
            Socket socket = new Socket("localhost", 8888);
            //使用DataOutputStream向服务器发送数据
            dos = new DataOutputStream(socket.getOutputStream());
            // 向服务器发送数据
            dos.writeUTF("服务器你好，我向你发送消息了！");


            // 接收服务的响应信息
            dis = new DataInputStream(socket.getInputStream());
            String response = dis.readUTF();
            System.out.println("服务器响应的信息为： " + response);

            // 注意流的关闭时机
//            dis.close();
//            dos.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
