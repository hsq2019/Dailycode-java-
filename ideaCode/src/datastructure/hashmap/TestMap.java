package datastructure.hashmap;

import datastructure.hashtab.HashTabDemo;
//map 键值队，key和value，key和value是映射关系
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        //1 给hashMap添加元素
        map.put(1,"hello");
        map.put(1,"hello");
        map.put(1,"good");
        map.put(2,"world");
        map.put(3,"java");
        //2 输出map内容 不同的集合类里面都有相应不同的toString方法
        System.out.println(map);
        //3 根据key获取value
        System.out.println(map.get(1));
        System.out.println(map.get(4));
        //4 打印所有的key,key的元素不重复
        for(Integer key:map.keySet()){
            System.out.print(key+" ");
        }
        System.out.println();
        //5 打印所有的value
        for(String value:map.values()){
            System.out.print(value+" ");
        }
        System.out.println();
        //6 按照key-value的映射关系打印
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        //使用迭代器打印
        Iterator<Map.Entry<Integer, String>> iterator= map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
