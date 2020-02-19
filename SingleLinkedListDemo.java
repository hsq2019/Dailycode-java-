package datastructure.linkedlist;
//单向，不带环，有傀儡节点
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");
        //创建单链表对象
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        //加入内容
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        //显示
        singleLinkedList.list();
    }
}
//定义一个SingleLinkedList来管理英雄
class SingleLinkedList{
    //先初始化头节点,头节点不能动
    private HeroNode head=new HeroNode(0,"","");

    //增。。。。。添加节点到单链表
    //从尾部加元素
    public void add(HeroNode heroNode){
        HeroNode temp=head;
        //遍历链表，找到最后
        while (true){
            if(temp.next==null){
                break;
            }
            //如果没有找到最后，讲temp后移
            temp=temp.next;
        }
        //让新节点等于最后一个节点的next
        temp.next=heroNode;
    }

    //显示链表[遍历]
    public void list(){
        //链表为空
        if(head.next==null){
            System.out.println("链表为空");
            return ;
        }
        HeroNode temp=head.next;
        while (true){
            //判断链表最后
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
    //第二种增加方式，按照编号来插入，小的在前，大的在后
    //如果有同样的编号那就会报错
    public void addByOrder(HeroNode heroNode){
        //头不能动，所以设置一个temp
        //找的temp，位于添加位置的签一个节点
        HeroNode temp=head;
        boolean flag=false;//添加的编号是否存在
        while(true){
            if(temp.next==null){
                //说明
                break;
            }
            if(temp.next.no>heroNode.no){
                //位置找到,就在temp的后面插入
                break;
            }else if(temp.next.no==heroNode.no){
                flag=true;//编号存在
                break;
            }
            temp=temp.next;//后移
        }
        //判断falg
        if(flag){
            System.out.println("准备插入的英雄编号已经存在，不能加入"+heroNode.no);
        }else{
            //插入到temp的后面
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }



}

//定义一个HeroNode，每个HeroNode对象都是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    //构造器
    public HeroNode(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }
    //重写toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
