package com.kenson.map.hashmap;

import com.kenson.bean.Wife;

/**
 * Define a myself map , it is not a perfect collection of Map Map: store
 * Key-Value, find the value via Key!
 * 通过源码实现Map
 * Map的底层实现原来是： 数组 + 链表
 *
 * @author wuchun
 */
public class MyMap {
    MyEntry[] arr = new MyEntry[999];
    int size;

    public void put(Object key, Object value) {
        MyEntry e = new MyEntry(key, value);
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                arr[i].value = value;
                return;
            }
        }
        arr[size++] = e;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return arr[i].value;
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (arr[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyMap myMap = new MyMap();
        myMap.put("Ken", new Wife("Jan"));
        myMap.put("Jan", "look");
        Wife w = (Wife) myMap.get("Ken");

        System.out.println(w.getName());

        System.out.println(myMap.containsKey("Ken1"));
        System.out.println(myMap.containsValue(new Wife("Jan")));
    }

}

class MyEntry {
    Object key;
    Object value;

    public MyEntry() {
    }

    public MyEntry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }

}