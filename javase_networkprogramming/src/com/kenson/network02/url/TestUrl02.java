package com.kenson.network02.url;

import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description: 获取资源： 源代码
 * 类似于爬虫程序
 * @author: Kenson
 * @date: 2020/9/25
 */
public class TestUrl02 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com/");

            // 通过字节流的方式读取百度首页资源
            // 获取网络资源
            /*InputStream is = url.openStream();
            // 缓冲数组
            byte[] flush = new byte[1024];
            // 每次读取长度
            int len = 0;
            while ((len = is.read(flush)) !=-1){
                String content = new String(flush, 0, len);
                System.out.println(content);
            }*/

            // 通过字符流的方式读取百度首页的资源
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("./javase_networkprogramming/baidu.html"))));
            String rMsg = null;
            while ((rMsg = br.readLine()) != null) {
                bw.append(rMsg);
                bw.newLine();
            }
            bw.flush();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
