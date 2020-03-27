package datastructure.doublelinkedlist;

public class DoubleLinkingListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");
        DoubleLinkedList doubleLinkingList=new DoubleLinkedList();
        doubleLinkingList.add(hero1);
        doubleLinkingList.add(hero2);
        doubleLinkingList.add(hero3);
        doubleLinkingList.add(hero4);
        doubleLinkingList.list();
        //修改
        HeroNode newHeroNode=new HeroNode(4,"公孙胜","入云龙");
        doubleLinkingList.update(newHeroNode);
        System.out.println("修改过后的链表");
        doubleLinkingList.list();
        //删除
        doubleLinkingList.del(3);
        System.out.println("删除后的链表");
        doubleLinkingList.list();

    }
}

//创建一个双向链表的类
class DoubleLinkedList{
    //初始化头节点
    private HeroNode head=new HeroNode(0,"","");
    //返回头节点
    public HeroNode getHead(){
        return head;
    }
    //遍历双向链表(显示)
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        while (temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }
    //添加（添加到末尾）
    public void add(HeroNode heroNode){
        HeroNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=heroNode;
        heroNode.pre=temp;
    }
    //修改
    public void update(HeroNode newHeroNode){
        //判断是否是空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        boolean flag=false;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else{
            System.out.println("不能修改");
        }
    }
    //删除，双向链表只找到删除节点就行
    public void del(int no){
        if(head.next==null){
            System.out.println("链表为空，不能删除");
        }
        HeroNode temp=head.next;
        boolean flag=false;
        while (true){
            if(temp==null){
                break;
            }
            if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.pre.next=temp.next;
            //如果是删除的是最后一个节点，就不用执行下面那句话,要不然会空指针异常
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else{
            System.out.println("没找到删除的节点！");
        }
    }
    //

}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向后一个节点，默认null
    public HeroNode pre;//只想前一个节点，默认null

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
