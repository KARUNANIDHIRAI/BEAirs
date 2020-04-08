package com.cTechInfoSys.linkList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LIstLinked {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("add item in the list");
		list.add("karuna Nidhi Rai");
		list.add("Ram Narayan Rai");
		list.add("Shyam Narayan Rai");
		list.add("katah baachak Rai");

		System.out.println("list.size for loop");
		for(int num=0;num<list.size();num++) {
			System.out.println(list.get(num));
		}
		
		System.out.println("lst :list for loop");
		for(String lst:list) {
			System.out.println(lst);
		}

		System.out.println("iterator for loop");
		Iterator<String> lst= list.iterator();
		while(lst.hasNext()) {
			System.out.println(lst.next());
		}

		System.out.println("get indexpoints for loop");
		int num=0;
		while (num<list.size()) {
			System.out.println(list.get(num));
			num++;
		}

	   System.out.println("--------hashMap----------");
	   HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	   HashMap<Integer, String> hmapp = new HashMap<Integer, String>();
	   hmap.put(1,"RAM0");
	   hmap.put(1,"RAM1");
	   hmap.put(1,"RAM2");
	   hmap.put(1,"RAM3");
	   System.out.println("-------------" + hmap+ "--------------");
	  
	
	   Map<String, Integer> map = new HashMap<>();
       map.put("web", 1024);
       map.put("database", 2048);
       map.put("static", 5120);

       System.out.println("Java 8 forEach loop");
       map.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));

       System.out.println("for entrySet()");
       for (Map.Entry<String, Integer> entry : map.entrySet()) {
           System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
       }

       System.out.println("Iterator");
       Iterator iter = map.entrySet().iterator();
       while (iter.hasNext()) {
           Map.Entry entry = (Map.Entry) iter.next();
           System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
       }	    
	   
	}

}
