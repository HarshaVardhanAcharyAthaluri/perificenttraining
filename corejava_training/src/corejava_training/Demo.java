package corejava_training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Demo {
	

	
	public static void main(String[] args) {
		
		Map<Integer, String> map = new Hashtable();
		
		map.put(1, "vivek");
		map.put(47, "anand");
		map.put(76, "Ross");
		map.put(33, "chandler");
		map.put(54, "pheebe");
		map.put(28, "Joe");
		map.put(97, "vivek");
		System.out.println("Before Duplicate ");
		System.out.println(map);
		System.out.println("After Duplicate ");
		map.put(97, "monika");
		System.out.println(map);
	}
}
