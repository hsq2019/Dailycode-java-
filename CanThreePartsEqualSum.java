class Solution {
    //力扣1013 将数组分成和相等的三个部分
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int x:A){
            sum+=x;
        }
        if(sum%3!=0){
            return false;
        }
        int num=sum/3;
        int i=0;
        sum=0;
        for(;i<A.length;i++){
            sum+=A[i];
            if(sum==num){
                break;
            }
        }
        if(sum!=num||i==A.length-1){
            return false; 
        }
        int j=i+1;
        sum=0;
        for(;j<A.length;j++){
            sum+=A[j];
            if(sum==num){
                break;
            }
        }
         if(sum!=num||j==A.length-1){
            return false; 
        }
        sum=0;
        for(int k=j+1;k<A.length;k++){
            sum+=A[k];
        }
        if(sum==num){
            return true;
        }else{
            return false;
        }
    }
} 