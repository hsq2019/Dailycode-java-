package datastructure.set;

//搜索的数据叫做关键字key，关键字所对应的值是value
//set 只有key(纯key模型)
//map  有key有value(key-value模型)
//set和map中的组织顺序和插入顺序无关

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        //1.往set中加入元素
        set.add("hello");
        set.add("world");
        set.add("java");
        //2.看字符串"java"在不在hashSet中
        System.out.println(set.contains("java"));
        //3.删除数据key
        set.remove("java");
        System.out.println(set.contains("java"));
        System.out.println(set);
        System.out.println("==============");
        //使用迭代器去遍历set中的元素
        //迭代器的泛型参数，要和集合类中的泛型参数保持一致
        //集合类内部有实现自己版本的迭代器类，不同的集合类里面的迭代器类型不同
        System.out.println("迭代器实现遍历set");
        Iterator<String> iterator=set.iterator();
        while (iterator.hasNext()){
            String next=iterator.next();
            System.out.print(next+" ");
        }

    }
}
