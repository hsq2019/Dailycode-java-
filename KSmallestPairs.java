class Solution {
    //力扣373
    //查找和最小的前k对数字
    //先把数字队放到一个优先级队列中，建小堆，之后取前k个队
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums1.length==0||nums2.length==0||k<=0){
            return res;
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                queue.offer(new Pair(nums1[i],nums2[j]));
            }
        }
        for(int i=0;i<k&&!queue.isEmpty();i++){
            Pair cur=queue.poll();
            List<Integer> temp=new ArrayList<>();
            temp.add(cur.n1);
            temp.add(cur.n2);
            res.add(temp);
        }
        return res;
    }
}
//建立一个pari类
//继承comparable接口
class Pair implements Comparable<Pair>{
    public int n1;
    public int n2;
    public int sum;
    public Pair(int n1,int n2){
        this.n1=n1;
        this.n2=n2;
        this.sum=n1+n2;
    }
    @Override
    public int compareTo(Pair o){
        return this.sum-o.sum;
    }
}