package com.kenson.compare.referencetypecompare;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 考虑新闻条目排序
 * 新闻条目的实体类
 * @author wuchun
 *
 */
public class NewsItem implements Comparable<NewsItem> {
	//标题
	private String title;
	
	//点击量
	private int hit;
	
	//时间
	private Date pubTime;
	
	public NewsItem(){
		
	}
	
	public NewsItem(String title, int hit, Date pubTime) {
		this.title = title;
		this.hit = hit;
		this.pubTime = pubTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	//时间降序+点击量升序+标题升序
	@Override
	public int compareTo(NewsItem o) {
		int result = 0;
		//比较时间，无非就是正数 ， 负数 和 0
		result = -this.pubTime.compareTo(o.pubTime);	//负数就是降序了
		if(0==result){	//如果时间相同
			 //点击量
			result = this.hit - o.hit;	//升序
			if(0==result){	//点击量相同
				//标题降序
				result = -this.title.compareTo(o.title);
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("标题：").append(this.title);
		sBuilder.append("时间：").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pubTime));
		sBuilder.append("点击量：").append(this.hit).append("\n");
		return sBuilder.toString();
	}
	

}
