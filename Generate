class Generate {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0){
            return new ArrayList<>();
        }        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> first=new ArrayList<>();
        first.add(1);
        res.add(first);
        if(numRows==1){
            return res;
        }
        List<Integer> second=new ArrayList<>();
        second.add(1);
        second.add(1);
        res.add(second);
        if(numRows==2){
            return res;
        }
        //从第三行开始，到numRows行结束
        for(int i=3;i<=numRows;i++){
            //所对应的下标要注意
            List<Integer> prev=res.get(i-1-1);
            List<Integer> cur=new ArrayList<>();
            //cur这一行的第一个数字是1
            cur.add(1);
            //中间的值计算循环
            for(int j=2;j<i;j++){
                int num=prev.get(j-1-1)+prev.get(j-1);
                cur.add(num);
            }
            //cur这一行最后一个数也是1
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
