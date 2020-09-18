package com.kenson.io8.convertstream;

import com.kenson.io.util.CloseStreamUtil;

import java.io.*;

/**
 * @description: 转换流：OutputStreamWriter 和 IutputStreamReader
 * 转换流是 字节 ---> 字符
 * OutputStreamWriter --- 编码
 * IutputStreamReader --- 解码
 * @author: Kenson
 * @date: 2020/9/18
 */
public class Test02ConvertStream {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 解码
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                    new File("javase_io/src/sourceFiles/ConvertFile.txt")), "UTF-8"));
            // 编码
            bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(
                    new File("javase_io/src/destFiles/EncodeConvertFile.txt")), "UTF-8"));
            String info = null;
            while ((info = br.readLine()) != null) {
                bw.write(info);
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseStreamUtil.closeAllStream(br, bw);
        }
    }
}
