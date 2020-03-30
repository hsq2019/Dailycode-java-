/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //二叉树的前序遍历,使用递归方法
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        //先访问根节点
        res.add(root.val);
        //访问左子树，把左子树的结果全部加入到res中
        res.addAll(preorderTraversal(root.left));
        //访问右子树，把右子树的遍历完成结果加入到res中
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}