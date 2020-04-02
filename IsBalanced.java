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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            //根节点为空，那么平衡
            return true;
        }
        if(root.left==null&&root.right==null){
            //没有子树，平衡
            return true;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        if(leftDepth-rightDepth>1||leftDepth-rightDepth<-1){
            //不平衡
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}