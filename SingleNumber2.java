class Solution {
    //使用map
    public int singleNumber(int[] nums) {
      Map<Integer,Integer> map=new HashMap<>();
      for(int x:nums){
          Integer value=map.get(x);
          
          if(value==null){
               //如果map中没有当前数字，那么就要在map中添加
              map.put(x,1);
          }else{
              //如果map中有当前数字，那么改变value就行
              map.put(x,value+1);
          }
      }
      //遍历map
      for(Map.Entry<Integer,Integer> entry:map.entrySet()){
          if(entry.getValue().equals(1)){
              return entry.getKey();    
          }
      }
      return 0;
    }
}