class Solution {
    //两个相同的数字异或结果是0
    //0与整数n异或结果还是n
    public int singleNumber(int[] nums) {
        int num=0;
       for(int i=0;i<nums.length;i++){
           num^=nums[i];
       }
       return num;
    }
}