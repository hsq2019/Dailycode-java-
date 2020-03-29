/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //二叉树的中序遍历（递归）
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        //左
        res.addAll(inorderTraversal(root.left));
        //中
        res.add(root);
        //右
        res.addAll(inorderTraversal(root.right));
        return res;
    }
}