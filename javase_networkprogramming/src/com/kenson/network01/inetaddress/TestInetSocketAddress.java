package com.kenson.network01.inetaddress;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @description: 测试 InetSocketAddress
 * InetSocketAddress在InetAddress的基础封装了 端口
 * @author: Kenson
 * @date: 2020/9/25
 */
public class TestInetSocketAddress {
    public static void main(String[] args) {
        try {
            InetSocketAddress address1 = new InetSocketAddress("192.168.2.115", 3306);
            System.out.println(address1.getHostName());
            System.out.println(address1.getPort());

            InetSocketAddress address2 = new InetSocketAddress(InetAddress.getLocalHost(), 9999);
            System.out.println(address2.getHostName());
            System.out.println(address2.getPort());

            InetSocketAddress address3 = new InetSocketAddress(InetAddress.getByName("192.168.163.1"), 9999);
            System.out.println(address3.getHostName());// 返回主机名
            System.out.println(address3.getPort()); // 返回端口
            System.out.println(address3.getHostString()); // 主机名

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
