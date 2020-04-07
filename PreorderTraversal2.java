/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //二叉树的前序遍历（迭代方法）
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top=stack.pop();
            res.add(top.val);
            if(top.right!=null){
                stack.push(top.right);
            }
            if(top.left!=null){
                stack.push(top.left);
            }
        }
        return res;
    }
}