package datastructure.heap;

import java.util.PriorityQueue;

public class TestPriorityQueue {
    //Java标准库中的优先级队列的使用
    public static void main(String[] args) {
        //标准库中默认是建一个小堆
        PriorityQueue<Integer> queue=new PriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isEmpty()) {
            //取元素
            int cur = queue.poll();
            System.out.print(cur + " ");
        }
    }
}
