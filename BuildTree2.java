/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //根据后序遍历和中序遍历构造二叉树
 //后序反过来遍历是根 右 左（注意顺序）
 
class Solution {
    public int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null&&postorder==null){
            return null;
        }
        index=postorder.length-1;
        return helper(inorder,postorder,0,postorder.length);
    }
    public TreeNode helper(int[] inorder, int[] postorder,int left,int right){
        if(left>=right){
            return null;
        }
        if(index<0){
            return null;
        }
        TreeNode root=new TreeNode(postorder[index]);
        index--;
        int pos=find(inorder,root.val,left,right);
        root.right=helper(inorder,postorder,pos+1,right);
        root.left=helper(inorder,postorder,left,pos);
        return root;
    }
    private int find(int[] inorder, int toFind,int left,int right){
        for(int i=left;i<right;i++){
            if(toFind==inorder[i]){
                return i;
            }
        }
        return -1;
    }
}