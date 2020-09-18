package com.kenson.map.weakhashmap;

import java.util.EnumMap;

/**
 * EnumMap 
 * @author wuchun
 *
 */
public class TestEnumMap {
	public static void main(String[] args) {
		EnumMap<Season, String> map = new EnumMap<Season, String>(Season.class);
		//存放值
		map.put(Season.SPRING, "春困");
		map.put(Season.SUMMER, "夏热");
		map.put(Season.AUTUMN, "秋乏");
		map.put(Season.WINTER, "冬冷");
		System.out.println(map.size());
		System.out.println(map.keySet());
	}

}

enum Season{
	SPRING,SUMMER, AUTUMN,WINTER
}