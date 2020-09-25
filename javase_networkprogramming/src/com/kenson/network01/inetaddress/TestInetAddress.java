package com.kenson.network01.inetaddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @description: InetAddress类表示Internet协议版本4（IPv4）地址
 * InetAddress类 是没有封装端口
 * @author: Kenson
 * @date: 2020/9/24
 */
public class TestInetAddress {
    public static void main(String[] args) {
        // InetAddress 该类无构造方法只有静态方法
        try {
            // 以文本表示形式返回IP地址字符串
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);// DESKTOP-GU3HFG6/9.197.240.110 (主机名/IP)
            // 获取主机名
            String hostName = localHost.getHostName();
            //返回本机ip地址： 192.168.126.1
            String hostAddress = localHost.getHostAddress();
            // 返回此InetAddress对象的原始IP地址。 结果是网络字节顺序：地址的最高位字节在getAddress()[0]
            byte[] address = localHost.getAddress();
            System.out.println(hostName);
            System.out.println(hostAddress);
            System.out.println(Arrays.toString(address));

            // 根据域名得到InetAddress对象
            InetAddress domainName = InetAddress.getByName("www.163.com");
            System.out.println("返回163服务器的ip:" + domainName.getHostAddress());
            System.out.println("返回163的主机名：" + domainName.getHostName());

            // 根据IP得到InetAddress对象
            InetAddress ipName = InetAddress.getByName("182.242.144.3");
            System.out.println("返回服务器IP：" + ipName.getHostAddress());
            System.out.println("返回服务器主机名" + ipName.getHostName());
//            System.out.println(ipName.getCanonicalHostName());
            System.out.println(ipName.isAnyLocalAddress());
            System.out.println(ipName.isLoopbackAddress());
            System.out.println(ipName.isMCGlobal());
            System.out.println(ipName.isReachable(1000));
            // 检查InetAddress是否是IP组播地址的实用程序
            System.out.println(ipName.isMulticastAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
