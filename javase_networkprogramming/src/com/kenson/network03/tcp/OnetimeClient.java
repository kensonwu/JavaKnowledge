package com.kenson.network03.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @description: 模拟客户端
 * 场景为： 客户端发送信息给服务器端
 * 注意： 客户端向服务器端发送数据， 客户端使用 OutputStream 服务器端使用InputStream
 * 服务器端向客户端发送数据， 服务器端使用OutputStream 服务器端使用InputStream
 * 总之： 无论是客户端还是服务器端 给对方发送数据 都使用OutputStream
 * @author: Kenson
 * @date: 2020/9/25
 */
public class OnetimeClient {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            // 创建Socket对象 包含服务器地址以及端口
            Socket cilent = new Socket("localhost", 8888);
            // 发送数据使用OutputStream
            // 此处作为测试， 我们使用DataOutputStream
            dos = new DataOutputStream(cilent.getOutputStream());
            // 写入数据
            dos.writeUTF("你好，服务器，这是我第一次访问您！");
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
