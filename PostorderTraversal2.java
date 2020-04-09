/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }   
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode prev=null;
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode top=stack.peek();
            if(top.right==null||top.right==prev){
                res.add(top.val);
                stack.pop();
                prev=top;
            }else{
                cur=top.right;
            }
        }
        return res;
    }
}