class Solution {
    public String reverseOnlyLetters(String S) {
        char[] s=S.toCharArray();
        int left=0;
        int right=s.length-1;
        while(left<=right){
            if(!Character.isLetter(s[left])){
                left++;
            }else if(!Character.isLetter(s[right])){
                right--;
            }else{
                char temp='0';
                temp=s[left];
                s[left]=s[right];
                s[right]=temp;
                left++;
                right--;
            }
        }
        S=String.valueOf(s);
        return S;
   }
}
