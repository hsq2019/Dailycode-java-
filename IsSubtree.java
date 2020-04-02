/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //判断另一个树的子树
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        boolean res=false;
        if(s.val==t.val){
            res=isSameTree(s,t);
        }
        if(!res){
            res=isSubtree(s.left,t);
        }
        if(!res){
            res=isSubtree(s.right,t);
        }
        return res;
    }
    //判断两棵树是否相等
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right); 
    }
}