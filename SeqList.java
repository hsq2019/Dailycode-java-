package datastructure.seqlist;

public class SeqList {
    private int[] datas =null;
    private  int size=0;//有效元素
    //构造方法
    public SeqList(){
        //顺序表的初始化容量是100，长度为0
        datas =new int[100];
    }

    //依次打印每个元素
    public void display(){
        String result="[";
        for(int i=0;i<size;i++){
            result+= datas[i];
            if(i<size-1){
                result+=",";
            }
        }
        result+="]";
        System.out.println(result);
    }

    //插入值
    //pos是插入位置，data是插入值
    public void add(int pos,int data){
        //判断pos石否有效
        if(pos<0||pos>size){
            return;
        }
        //扩容
        if(size>=datas.length) {
            int[] newDatas=new int[2*datas.length];
            for(int i=0;i<datas.length;i++){
                newDatas[i]=datas[i];
            }
            datas=newDatas;//地址
        }
        //尾插
        if(pos==size){
            datas[size]=data;
            size++;
            return;
        }
        //普通插入
        for(int i=size-1;i>=pos;i--){
            datas[i+1]=datas[i];
        }
        datas[pos]=data;
        size++;
    }

    //判定是否包含一个元素
    public boolean contains(int toFind){
        //循环访问每个元素并比较
        for(int i=0;i<size;i++){
            if(datas[i]==toFind){
                return true;
            }
        }
        return false;
    }

    //查找一个数
    public int search(int toFind){
        for(int i=0;i<size;i++){
            if(datas[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    //获取pos的位置元素
    public Integer getPos(int pos){
        if(pos<size&&pos>=0){
            return datas[pos];
        }
        return null;
    }

    //给pos位置的元素设为value
    public void stePos(int pos,int value){
        datas[pos]=value;
    }

    //删除给定值,toRemove表示的是要被删的元素值
    public void remove(int toRemove){
        //先找到当前删除的位置小标
        //看下标是否是最后一个元素
        //如果中间元素，先搬运后尾删
        //删完都是size--
        int pos=search(toRemove);
        if(pos==-1){
            return;
        }
        if(pos==size-1){
            size--;
            return;
        }
        for(int i=pos;i<size-1;i++){
            datas[i]=datas[i+1];
        }
        size--;
    }

    //清除所有元素
    public void clear(){
        size=0;
    }
}
