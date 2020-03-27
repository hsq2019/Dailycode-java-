package datastructure.josepfu;

public class Josepfu {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        //加入5个孩子
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //测试小孩出圈
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
//创建环形单向链表
class CircleSingleLinkedList{
    //创建first节点,没有编号
    private Boy first=new Boy(-1);


    //添加节点，nums个
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        //创建环形链表
        Boy curBoy=null;
        for(int i=1;i<=nums;i++){
            //根据编号创建Boy节点
            Boy boy=new Boy(i);
            //如果第一个boy
            if(i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
    //遍历当前的环形链表
    public void showBoy(){
        //判断是不是空
        if(first==null){
            System.out.println("没有任何小孩");
            return;
        }
        //first不能动，使用辅助指针完成遍历
        Boy curBoy=first;
        while (true){
            System.out.println("小孩的编号"+curBoy.getNo());
            if(curBoy.getNext()==first){//遍历完毕
                break;
            }
            curBoy=curBoy.getNext();//后移
        }
    }
    //根据用户的输入，计算出出圈顺序

    /**
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums  表示最初有多少小孩在圈里
     */
    public void countBoy(int startNo,int countNum,int nums){
        //对数据进行检验
        if(first==null||startNo<1||startNo>nums){
            System.out.println("参数有误，请重新输入");
            return;
        }
        //创建辅助指针
        Boy helper=first;
        //helper指向最后一个节点
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
         for(int i=0;i<startNo-1;i++){
             first=first.getNext();
             helper=helper.getNext();
         }
         //开始报数
        //是指helper和first移动countNUm-1
        //直到圈中只有一个节点
         while (true){
             if(helper==first){
                 //圈只有一个节点
                 break;
             }
             for(int j=0;j<countNum-1;j++){
                 first=first.getNext();
                 helper=helper.getNext();
             }
             //first指向的节点是出圈节点
             System.out.println("小孩"+first.getNo()+"出圈");
             first=first.getNext();
             helper.setNext(first);
         }
        System.out.println("小孩"+first.getNo()+"出圈");
    }
}

//先创建boy节点
class Boy{
    private int no;//编号
    private Boy next;//指向下一个节点，默认null
    public Boy (int no){
        this.no=no;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }


}
