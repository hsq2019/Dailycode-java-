class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        for(int i=0;i<Math.pow(2,len);i++){
            List<Integer> tmp=new ArrayList<Integer>();
            for(int j=0;j<len;j++){
                if((i>>j)%2==1){
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }
    return res;
    }
}
