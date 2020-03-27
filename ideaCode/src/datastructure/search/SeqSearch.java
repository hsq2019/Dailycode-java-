package datastructure.search;

//顺序查找（线性查找）
//数组是无序的
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr={1,5,8,4,3,10};
        int res=seqSearch(arr,8);
        if(res==-1){
            System.out.println("没有查找到");
        }else{
            System.out.println("找到了，下标是"+res);
        }
    }

    /**
     *
     * @param arr 查找的数组
     * @param value 查找的值
     * @return
     */
    public static int seqSearch(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }

}
