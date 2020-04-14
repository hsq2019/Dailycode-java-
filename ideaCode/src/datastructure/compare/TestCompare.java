package datastructure.compare;

//使用comparable接口，要让比较的类实现comparable接口(需要修改待比较类的代码)  耦合性强
//实际开发中不是所有的类都能修改源码。comparable只能写一份比较规则

//使用comparator接口，重新创建一个新的类实现comparator接口(不用改变待比较类的代码)
//comparator可以定义多个比较规则

import java.util.Comparator;

//判断地址“==”
//判断内容 n1.equals(n2),但是equals方法得自己写，要不然和==一样
//判断是不是同一类型  instanceof
class Card implements Comparable<Card>{
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    //重写equals方法
    public boolean equals(Object obj) {
        //如果两个是同一个对象的话，那么相等
        if(this==obj){
            return true;
        }
        //this不能是空
        //obj如果为空肯定不相等
        if(obj==null){
            return false;
        }
        //如果obj与card是card类的时候，那与this肯定不同
        //this是card类
        if(!(obj instanceof Card)){
            return false;
        }
        //真正比较的内容
        //obj是object类型的
        //向下转型(类型转换)有风险，但是上一步排除了不是一个类型的情况
        Card other=(Card)obj;
        return this.rank.equals(other.rank)&&this.suit.equals(other.suit);
    }

    @Override
    public int compareTo(Card o) {
        //如果this大于o，那么返回一个大于0的数字
        //如果this小于o，那么返回一个小于0的数字
        //如果this等于o，那么返回0
        int rank1=this.getvalue();
        int rank2=o.getvalue();
        if(o==null){
            return 1;
        }
        return rank1-rank2;
    }

    public int getvalue() {
        //把string类型的rank，转化成int类型的rank
        int value=0;
        if("J".equals(rank)){
            value= 11;
        }else if("Q".equals(rank)){
            value=  12;
        }else if("K".equals(rank)){
            value=  13;
        }else if("A".equals(rank)){
            value=  1;
        }else{
            value=Integer.parseInt(rank);
        }
        return value;
    }
}

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1,Card o2){
        if(o1==o2){
            return 0;
        }
        if(o2==null){
            return 1;
        }
        if(o1==null){
            return -1;
        }
        int rank1=o1.getvalue();
        int rank2=o2.getvalue();
        return rank1-rank2;
    }

}

public class TestCompare {
    public static void main(String[] args) {
        Card card1=new Card("4","♠");
        Card card2=new Card("4","♠");
        Card card4=new Card("A","♦");
        Card card5=new Card("K","♦");
        Card card3=card1;
        //输出false
        System.out.println(card1==card2);
        //输出true
        System.out.println(card1==card3);
        System.out.println("====================");
        //如果equals没重写，输出结果是false
        //如果equals方法重写了，输出的结果是true
        System.out.println(card1.equals(card2));
        //equals没重写，输出结果是true
        //如果equals方法重写了，输出的结果是true
        System.out.println(card1.equals(card3));
        System.out.println(card1.compareTo(card2));
        System.out.println(card1.compareTo(card4));
        System.out.println(card1.compareTo(card5));
        System.out.println("=====================");
        CardComparator comparable=new CardComparator();
        System.out.println(comparable.compare(card4,card5));;
    }
}
