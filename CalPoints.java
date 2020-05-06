class Solution {
   //力扣682
   //棒球比赛
   
    public int calPoints(String[] ops) {
        Stack<Integer> s=new Stack<>();
        for(String s1:ops){
            if(s1.equals("D")&&!s.empty()){
                s.push(s.peek()*2);
            }else if(s1.equals("C")&&!s.empty()){
                s.pop();
            }else if(s1.equals("+")&&!s.empty()){
                int a=s.pop();
                int b=s.peek();
                s.push(a);
                s.push(a+b);
            }else{
                s.push(Integer.parseInt(s1));
            }
        }
        int res=0;
        while(!s.empty()){
            res=res+s.pop();
        }
        return res;
    }
}