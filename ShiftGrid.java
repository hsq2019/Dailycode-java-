class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //先把二维数组里面的值迁移的放在一维数组中，之后再按把一维数组转化成二维网格
        //iMax是行数
        int iMax=grid.length;
        //iMax是列数
        int jMax=grid[0].length;
        int[] nums=new int[iMax*jMax];
        for(int i=0;i<iMax;i++){
            for(int j=0;j<jMax;j++){
                k%=nums.length;
                nums[k]=grid[i][j];
                k++;
            }
        }
        k=0;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<iMax;i++){
            List<Integer> tempList=new ArrayList<>();
            for(int j=0;j<jMax;j++){
                tempList.add(nums[k]);
                k++;
            }
            res.add(tempList);
        }
        return res;
    }
}