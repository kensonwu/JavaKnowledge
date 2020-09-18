package com.kenson.other.guava;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 统计单词出现的次数
 * 1. 之前我们使用的HashMap， 分拣存储+面向对象的思维 ， 需要大量的判断
 * 2. Multiset: 无序 +　可重复 .count() 增强了可读性 +操作简单
 * 3. 后期可运用于会员访问网站的次数，每条新闻被每个ip访问的次数 等等
 * @author wuchun
 *
 */
public class excirseCountWords {
	public static void main(String[] args) {
		String string = "this is a cat and that is a mice and where is the food ?";
		//分割字符串
		String[] strArray = string.split(" ");
		//将字符串存入multiSet中
		Multiset<String> multiSet = HashMultiset.create();
		for (String temp : strArray) {
			System.out.println(temp);
			multiSet.add(temp);
		}
		
		//获取所有单词， 也就是遍历Multiset
		Set<String> letters = multiSet.elementSet();
		for (String temp2 : letters) {
			System.out.println(temp2 + "--->" + multiSet.count(temp2));
		}
	}

}
