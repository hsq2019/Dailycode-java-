/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //根据二叉树创建字符串
class Solution {
    StringBuilder sb=new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        //借助一个方法进行递归
        helper(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public void helper(TreeNode t){
        if(t==null){
            return;
        }
        sb.append("(");
        //根
        sb.append(t.val);
        //左
        helper(t.left);
        if(t.left==null&&t.right!=null){
            sb.append("()");
        }
        //右
        helper(t.right);
        sb.append(")");
    }
}