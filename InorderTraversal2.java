/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //二叉树的中序遍历(迭代方法)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(true){
            //先把左边的循环入栈
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode top=stack.pop();
            res.add(top.val);
            cur=top.right;
        }
        return res;
    }
}