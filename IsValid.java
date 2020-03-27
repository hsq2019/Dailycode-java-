class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
                continue;
            }
            if(stack.empty()){
                return false;
            }
            char temp=stack.pop();
            if(c==')'&&temp=='('){
                continue;
            }
            if(c==']'&&temp=='['){
                continue;
            }
            if(c=='}'&&temp=='{'){
                continue;
            }
            return false;
        }
        if(stack.empty()){
            return true;
        }
        return false;
       
    }
}