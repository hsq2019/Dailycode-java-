/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //找到最近的祖先节点
class Solution {
    private TreeNode lca=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        findNode(root,p,q);
        return lca;

    }
    public boolean findNode(TreeNode root,TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        //是否在左子树里面
        int left=findNode(root.left,p,q)?1:0;
        //是否在右子树里面
        int right=findNode(root.right,p,q)?1:0;
        //是否和root相等
        int mid=(root==p||root==q)?1:0;
        //如果是1，那么是在一棵子树里面找到了pq
        //如果是2，那么左子树和右子树，mid和左子树，mid和右子树找到了pq
        //3的情况不会发生
        if((left+right+mid)==2){
            lca=root;
        }
        return (left+right+mid)>0;
    }
}