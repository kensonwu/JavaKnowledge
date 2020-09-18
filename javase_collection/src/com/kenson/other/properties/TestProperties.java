package com.kenson.other.properties;

import java.util.Properties;

/**
 * Properties 资源配置文件的读写
 * Properties只能存储字符串
 * 1. key 与 value只能有字符串
 * 2. 存储与读取
 * setProperty(String key, String value)
 * getProperty(String key, String defaultValue)
 * 
 * @author wuchun
 *
 */
public class TestProperties {
	public static void main(String[] args) {
		//创建对象
		Properties property = new Properties();
		//存储
		property.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		property.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		property.setProperty("user", "test");
		property.setProperty("pwd", "lion");
		
		//获取
		String url = property.getProperty("url","test");
		System.out.println(url);
	}
}
