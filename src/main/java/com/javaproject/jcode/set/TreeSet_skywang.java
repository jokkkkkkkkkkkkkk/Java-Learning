package com.javaproject.jcode.set;

import java.util.Iterator;
import java.util.TreeSet;

/** TreeSet：提供有序的Set集合
 *<p> 支持一系列的导航方法。比如查找与指定目标最匹配项
 *<p> 不支持快速随机遍历，只能通过迭代器进行遍历
 *
 *<p> 能被克隆，支持序列化
 *<p> 非同步，iterator 方法返回的迭代器是fail-fast的
 *
 *<p> 元素支持2种排序方式：自然排序 或者 根据创建TreeSet 时提供的 Comparator 进行排序
 *
 *
 */
public class TreeSet_skywang {

	public static void main(String[] args) {
		
		// API
		TreeSet_APIs();
		
		
		// 测试遍历
		TreeSet<String> set = new TreeSet<String>();
		set.add("aaa");
		set.add("aaa");
		set.add("bbb");
		set.add("eee");
		set.add("ddd");
		set.add("ccc");

		// 顺序遍历TreeSet
		ascIteratorThroughIterator(set) ;
		// 逆序遍历TreeSet
		descIteratorThroughIterator(set);
		// 通过for-each遍历TreeSet。不推荐！此方法需要先将Set转换为数组
		foreachTreeSet(set);
	}

   
   
	   // 测试TreeSet的api
	public static void TreeSet_APIs() {
        String val;

        // 新建TreeSet
        TreeSet<String> tSet = new TreeSet<String>();
        // 将元素添加到TreeSet中
        tSet.add("aaa");
        // Set中不允许重复元素，所以只会保存一个“aaa”
        tSet.add("aaa");
        tSet.add("bbb");
        tSet.add("eee");
        tSet.add("ddd");
        tSet.add("ccc");
        System.out.println("TreeSet:"+tSet);

        // 打印TreeSet的实际大小
        System.out.printf("size : %d\n", tSet.size());

        // 导航方法
        // floor(小于、等于)
        System.out.printf("floor bbb: %s\n", tSet.floor("bbb"));
        // lower(小于)
        System.out.printf("lower bbb: %s\n", tSet.lower("bbb"));
        // ceiling(大于、等于)
        System.out.printf("ceiling bbb: %s\n", tSet.ceiling("bbb"));
        System.out.printf("ceiling eee: %s\n", tSet.ceiling("eee"));
        // ceiling(大于)
        System.out.printf("higher bbb: %s\n", tSet.higher("bbb"));
        // subSet()
        System.out.printf("subSet(aaa, true, ccc, true): %s\n", tSet.subSet("aaa", true, "ccc", true));
        System.out.printf("subSet(aaa, true, ccc, false): %s\n", tSet.subSet("aaa", true, "ccc", false));
        System.out.printf("subSet(aaa, false, ccc, true): %s\n", tSet.subSet("aaa", false, "ccc", true));
        System.out.printf("subSet(aaa, false, ccc, false): %s\n", tSet.subSet("aaa", false, "ccc", false));
        // headSet()
        System.out.printf("headSet(ccc, true): %s\n", tSet.headSet("ccc", true));
        System.out.printf("headSet(ccc, false): %s\n", tSet.headSet("ccc", false));
        // tailSet()
        System.out.printf("tailSet(ccc, true): %s\n", tSet.tailSet("ccc", true));
        System.out.printf("tailSet(ccc, false): %s\n", tSet.tailSet("ccc", false));


        // 删除“ccc”
        tSet.remove("ccc");
        // 将Set转换为数组
        String[] arr = (String[])tSet.toArray(new String[0]);
        for (String str:arr)
            System.out.printf("for each : %s\n", str);

        // 打印TreeSet
        System.out.printf("TreeSet:%s\n", tSet);

        // 遍历TreeSet
        for(Iterator iter = tSet.iterator(); iter.hasNext(); ) {
            System.out.printf("iter : %s\n", iter.next());
        }

        // 删除并返回第一个元素
        val = (String)tSet.pollFirst();
        System.out.printf("pollFirst=%s, set=%s\n", val, tSet);

        // 删除并返回最后一个元素
        val = (String)tSet.pollLast();
        System.out.printf("pollLast=%s, set=%s\n", val, tSet);

        // 清空HashSet
        tSet.clear();

        // 输出HashSet是否为空
        System.out.printf("%s\n", tSet.isEmpty()?"set is empty":"set is not empty");
    }   
   
   
   
   
   
   
   
   
    // 顺序遍历TreeSet
	public static void ascIteratorThroughIterator(TreeSet<String> set) {
	   System.out.print("\n ---- Ascend Iterator ----\n");
	   for(Iterator<String> iter = set.iterator(); iter.hasNext(); ) {
		   System.out.printf("asc : %s\n", iter.next());
       }
	}

    // 逆序遍历TreeSet
    public static void descIteratorThroughIterator(TreeSet<String> set) {
    	System.out.printf("\n ---- Descend Iterator ----\n");
    	for(Iterator<String> iter = set.descendingIterator(); iter.hasNext(); )
    		System.out.printf("desc : %s\n", (String)iter.next());
    }

    // 通过for-each遍历TreeSet。不推荐！此方法需要先将Set转换为数组
   private static void foreachTreeSet(TreeSet<String> set) {
	   System.out.printf("\n ---- For-each ----\n");
	   String[] arr = (String[])set.toArray(new String[0]);
	   for (String str:arr)
		   System.out.printf("for each : %s\n", str);
   }	

	
}