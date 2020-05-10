class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:words){
            Integer count=map.getOrDefault(s,0);
            map.put(s,count+1);
        }
        ArrayList<String> arrayList=new ArrayList(map.keySet());
        //排序一般默认是升序
        //但是这个题降序比较简单，所以自己重写一个compare
        Collections.sort(arrayList,new MyComparator(map));
        return arrayList.subList(0,k);
    }

    static class MyComparator implements Comparator<String> {
        private Map<String,Integer> map;
        public MyComparator(Map<String,Integer> map){
            this.map=map;
        }
        public int compare(String o1,String o2){
            //逆序要确保
            //o1>o2 返回 负数
            //o2>o1 返回 正数
            //o1=o2 使用String类中的比较来判断
            int count1=map.get(o1);
            int count2=map.get(o2);
            if(count1==count2){
                //使用string类中的比较
                return o1.compareTo(o2);
            }
            //count1-count2是升序排序
            //count2-count1是降序排序
            return count2-count1;
        }
    }
}
