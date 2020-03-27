package winter_homework;

class ChangeNumber {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7,9};
        int[] arr2={2,4,6,8,10};
        System.out.println("改变前");
        System.out.println("arr1是：");
        for(int x:arr1){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("arr2是：");
        for(int x:arr2){
            System.out.print(x+" ");
        }
        for (int i = 0; i <arr1.length ; i++) {
            int temp=0;
            temp=arr1[i];
            arr1[i]=arr2[i];
            arr2[i]=temp;
        }
        System.out.println();
        System.out.println("改变后");
        System.out.println("arr1是:");
        for(int x:arr1){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("arr2是：");
        for(int x:arr2){
            System.out.print(x+" ");
        }
    }
}
