package com.kenson.map.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OrderHashMap {
	public static void main(String[] args) {
		Map<String, Long> map = new HashMap<String, Long>(); 
		map.put("c", 33333L);  
	    map.put("a", 11111L);  
	    map.put("d", 44444L);  
	    map.put("e", 55555L);  
	    map.put("b", 22222L);
	    //将map.entrySet()转换成list  
        List<Entry<String, Long>> list = new ArrayList<Entry<String, Long>>(map.entrySet());
        Collections.sort(list,new Comparator<Entry<String, Long>>(){
        	@Override
        	public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
        		return o1.getValue().compareTo(o2.getValue());  
        	}
        });
        
        for (Entry<String, Long> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());  
        }  
	}
	
}
