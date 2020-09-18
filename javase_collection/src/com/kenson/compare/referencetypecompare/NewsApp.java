package com.kenson.compare.referencetypecompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 使用Collections
 * @author wuchun
 *
 */
public class NewsApp {
	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("China will be become the strongest country in the world! Japan is crying!",60, new Date(System.currentTimeMillis()-1000*60*60)));
		news.add(new NewsItem("China will be become the strongest country in the world!",100, new Date()));
		news.add(new NewsItem("China will be become the strongest country in the world!  US is scared",50, new Date(System.currentTimeMillis()-1000*60*60)));
		
		System.out.println("排序前的：" + news);
		
		//排序
		Collections.sort(news);
		System.out.println("排序后： " + news);
	}
}
