class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int[] arr=new int[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]==arr[left]){
                left++;
            }else if(nums[right]==arr[right]){
                right--;
            }else{
                break;
            }
        }
        if(left>=right){
            return 0;
        }
        return right-left+1;
    }
}
