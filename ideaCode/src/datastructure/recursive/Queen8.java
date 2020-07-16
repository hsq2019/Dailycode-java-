package datastructure.recursive;

//8皇后问题

public class Queen8 {
    //定一个max，表示有多少皇后
    int max=8;
    //设置一个一维数组，去存储皇后放置位置的结果
    int[] arr=new int[max];
    public static void main(String[] args) {
        Queen8 queue8=new Queen8();
        queue8.check(0);
    }

    //写一个方法，将皇后摆放的位置输出
    private void print(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //放置第n个皇后
    private void check(int n){
        if(n==max){
            print();
            //8皇后放好
            return;
        }
        //依次放皇后，还要判断是否冲突
        for(int i=0;i<max;i++){
            arr[n]=i;
            if(judge(n)){//不冲突
                //开始放n+1
                check(n+1);
            }
            //如果冲突的话继续执行arr[n]=i，循环
        }
    }
    //查看放置第n个皇后，就检测时候和前面已经拜访的皇后冲突
    private boolean judge(int n){
        for(int i=0;i<n;i++){
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                //判断是否是同一列，再判断是否是同一斜线，abs是求绝对值
                //没有必要判断行数，n是行数，一直递增
                return false;
            }
        }
        return true;
    }


}
