package datastructure;


public class SparseArrays {
    public static void main(String[] args) {
        int[][] arr=new int[5][5];
        arr[0][4]=1;
        arr[4][1]=2;
        //原始数组
        System.out.println("原始数组arr");
        for(int[] row:arr){
            for(int data:row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
        //先得到有效数字sum
        int sum=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(arr[i][j]!=0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=5;
        sparseArr[0][1]=5;
        sparseArr[0][2]=sum;
        //遍历二维数组把非0值赋给稀疏数组
        int count=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(arr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=arr[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("输出稀疏数组为");
        for(int i=0;i<sparseArr.length;i++){
            System.out.print(sparseArr[i][0]+"  "+sparseArr[i][1]+"  "+sparseArr[i][2]);
            System.out.println();
        }
        //将稀疏数组转化成原始数组newArr
        int[][] newArr=new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i=1;i<sparseArr.length;i++){
            newArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //输出数组newArr
        System.out.println("输出原始数组newArr是");
        for(int[] row:newArr){
            for(int data:row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }
}
