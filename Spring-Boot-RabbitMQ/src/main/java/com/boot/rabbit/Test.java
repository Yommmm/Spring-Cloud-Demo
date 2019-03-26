package com.boot.rabbit;

import java.util.concurrent.ConcurrentHashMap;

import com.boot.rabbit.vo.User;

public class Test {
	
	public static int MAXIMUM_CAPACITY = 1 << 30;

	public static void main(String[] args) {
		/*System.out.println(1 << 30);
		
		int sum = 2;
		for(int i = 1; i < 30; i++) {
			sum = sum * 2;
		}
		System.out.println(sum);
		
		System.out.println(16 >>> 1);
		
		
		int i = 2;
		System.out.println(i++ + ++i);*/
		User user = new User();
		System.out.println(user.hashCode());
		System.out.println(hash(user));
		System.out.println(2018699554 ^ 2);
		/*System.out.println(tableSizeFor(16));
		
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 1; i < 17; i++) {
			System.out.println(i);
			map.put("Key" + i, "Value:" + i);
		}*/
	}
	
	public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	
	public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
	
}
