package com.kenson.other.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用类相对路径读取配置文件
 * bin
 * 资源配置文件：
 * 	load(InputStream inStream)
	load(Reader reader)
 * 
 * @author wuchun
 *
 */
public class TestPropertiesLoadMethod {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象
		Properties property = new Properties();
		//读取, 相对路径的　bin
		property.load(TestPropertiesLoadMethod.class.getResourceAsStream("/Properties/db.properties"));
		//""表示bin目录， 不需要/
		property.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("Properties/db.properties"));
		System.out.println(property.get("url"));
	}
}
