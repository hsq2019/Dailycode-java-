package datastructure.heap;

//优先级队列
public class MyPriorityQueue {
    private int[] array=new int[100];
    private int size=0;
    //增加元素使用向上调整
    //增加元素
    public void offer(int x){
        array[size]=x;
        size++;
        shiftUp(array,size-1);
    }
    //建小堆为例
    public void shiftUp(int[] array,int index){
        //向上调整
        int child=index;
        int parent=(child-1)/2;
        while (child>0){
            if(array[parent]>array[child]){
                int temp=array[parent];
                array[parent]=array[child];
                array[child]=temp;
            }else{
                break;
            }
            child=parent;
            parent=(child-1)/2;
        }
    }

    public int poll(){
        //下标为0的是队首元素，如果想要删除队首元素的同时希望剩下的结构还是小堆
        int oldValue=array[0];
        array[0]=array[size-1];
        size--;
        shiftDown(array,size,0);
        return oldValue;
    }
    public static void shiftDown(int[] array,int size,int index){
        //小堆的向下调整
        int parent=index;
        //先假设child是左孩子节点
        int child=parent*2+1;
        while (child<size){
            if (child + 1 < size && array[child] > array[child + 1]) {
                child=child+1;
                //这时候的child不知道是左节点还是右节点
                //确定的是child下标中存的是较小数字
            }
            //如果parent中的值大于child中的值，那么交换
            if(array[parent]>array[child]){
                int temp=array[parent];
                array[parent]=array[child];
                array[child]=temp;
            }else{
                //调整完毕
                break;
            }
            //更新条件
            parent=child;
            child=parent*2+1;
        }
    }
    public int peek(){
        return array[0];
    }

    public boolean isEmpty(){
        return size==0;
    }
    public static void main(String[] args) {
        MyPriorityQueue queue=new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isEmpty()){
            //取元素
            int cur=queue.poll();
            System.out.print(cur+" ");
        }
    }
    //堆(优先级队列)，每次poll一个元素都是把优先级最高的或者最低的元素取出来
    //能解决topK问题，如果poll k次的话就相当于对原来的序列进行了排序
    //相当于先offer增加元素，进行向上调整（这个代码是以小堆为例子），建成了个小堆
    //之后poll出队列，先把第一个元素出队列，再把最后一个元素放在原来的队首元素的位置上，再进行向下调整，保证下面的堆还是最小堆
    //当然也可以建大堆
}
