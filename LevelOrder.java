/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //二叉树的层序遍历
 //力扣<102>练习
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return res;
        }
        //使用一个方法来调用
        helper(root,0);
        return res;
    }
    public void helper(TreeNode root,int level){
        if(level==res.size()){
            //新建一层
            res.add(new ArrayList<>());
        }
        //得到level层再添加相应的数字
        res.get(level).add(root.val);
        if(root.left!=null){
            helper(root.left,level+1);
        }
        if(root.right!=null){
            helper(root.right,level+1);
        }
    }
}