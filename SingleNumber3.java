class Solution {
    //给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
    //1 先把数组中所有的数字都异或起来，得到一个数字
    //2 在找这个数字二进制位一个不为0的位，用这个来进行分组
    //3 之后分成a，b两组，之后分别异或
    public int[] singleNumber(int[] nums) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            num^=nums[i];
        }
        int i=0;
        //找出num的不为0的一个位数
        for(;i<32;i++){
            if(((num>>i)&1)==1){
            break;
            }
        }
        int bit=1<<i;
        int a=0;
        int b=0;
        for(int x:nums){
            if((x&bit)==0){
                //放在a组
                a^=x;
            }else{
                //放在b组
                b^=x;
            }
        }
        int[] array={a,b};
        return array;
    }
}