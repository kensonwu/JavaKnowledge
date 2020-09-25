package com.kenson.network02.url;

import javafx.scene.media.SubtitleTrack;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description: 测试URL 类
 * @author: Kenson
 * @date: 2020/9/25
 */
public class TestUrl01 {
    public static void main(String[] args) {
        try {
            // 绝对路径构建
//            URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=kenson");
            URL url = new URL("https://www.baidu.com/s?wd=kenson&rsv_spt=1&rsv_iqid=0xc75d6e9500098753&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=7&rsv_sug1=5&rsv_sug7=101&rsv_sug2=0&rsv_btype=i&prefixsug=kenson&rsp=5&inputT=1058&rsv_sug4=1642");
            System.out.println(url.toString());
            System.out.println("-----------------");
            System.out.println("协议： " + url.getProtocol());
            System.out.println("域名： " + url.getHost());
            System.out.println("端口： " + url.getPort());
            System.out.println("资源： " + url.getFile());
            System.out.println("相对路径: " + url.getPath());
            System.out.println("锚点： " + url.getRef());// 锚点写在?之前将导致无法获取到参数，只有锚点写在最后才能获取到参数
            System.out.println("参数： " + url.getQuery());//?参数： 存在锚点 返回null ， 不存在， 返回正确
            System.out.println(url.getAuthority());
            System.out.println(url.getUserInfo());
            System.out.println(url.getContent());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
