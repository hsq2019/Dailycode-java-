class MyStack {
    private Queue<Integer> a=new LinkedList<>();
    private Queue<Integer> b=new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        a.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if(empty()){
            return null;
        }
        while(a.size()>1){
            b.offer(a.poll());
        }
        int ret=a.poll();
        Queue<Integer> temp=a;
        a=b;
        b=temp;
        return ret;
    }
    
    /** Get the top element. */
    public Integer top() {
        if(empty()){
            return null;
        }
        while(a.size()>1){
            b.offer(a.poll());
        }
        int ret=a.poll();
        b.offer(ret);
        Queue<Integer> temp=a;
        a=b;
        b=temp;
        return ret;


    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return (a.isEmpty()&&b.isEmpty());

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */