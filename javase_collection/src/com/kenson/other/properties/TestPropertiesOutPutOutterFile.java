package com.kenson.other.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties将资源配置输出到外部文件
 * 也就是平常所称的资源配置文件， 好处： 可以动态的切换不同的数据库或者 用户
 * 1. properties
 * store(OutputStream out, String comments)	---- 字节流
 * store(Writer writer, String comments)  --- 字符流
 * 二选一就好了， xml用相应的方法就好， 原理相同
 * 2. xml
 * storeToXML(OutputStream os, String comment)   默认UTF-8字符集
storeToXML(OutputStream os, String comment, String encoding)  自定义字符集

 * @author wuchun
 *
 */
public class TestPropertiesOutPutOutterFile {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象
		Properties property = new Properties();
		//存储
		property.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		property.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		property.setProperty("user", "test");
		property.setProperty("pwd", "lion");
		
		//存储 到C:/OneTEAM/OneTEAMTools/collection, 绝对路径盘符：
		property.store(new FileOutputStream("C:/OneTEAM/OneTEAMTools/collection/db.properties"), "db configuration file");
		property.storeToXML(new FileOutputStream("C:/OneTEAM/OneTEAMTools/collection/db.xml"), "db xml");
		
		//使用相对路径
		property.store(new FileOutputStream("src/Properties/db.properties"), "db configuration file");
		property.storeToXML(new FileOutputStream("src/Properties/db.xml"), "db xml");
	}
}
