package com.kenson.other.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties 资源配置文件的读写
 * 资源配置文件：
 * 	load(InputStream inStream)
	load(Reader reader)
 * 
 * @author wuchun
 *
 */
public class TestPropertiesRelativePath {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象
		Properties property = new Properties();
		//读取
//		property.load(new FileReader("C:/OneTEAM/OneTEAMTools/collection/src/Properties/db.properties"));
		property.load(new FileReader("src/Properties/db.properties"));
		System.out.println(property.getProperty("url"));
		
	}
}
