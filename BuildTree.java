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
    private int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        //index是遍历前序遍历时的下标
        index=0;
        //借助一个方法完成递归
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder,int left,int right){
        //left和right是一个区间
        if(left>=right){
            return null;
        }
        //index如果等于前序遍历或者后续遍历的长度，直接返回
        if(index>=inorder.length){
            return null;
        }
        //建立一个新节点，使用的是前序遍历数组index位
        TreeNode root=new TreeNode(preorder[index]);
        index++;
        //借助一个方法去在中序遍历中找到root.val 的值
        int pos=find(root.val,inorder,left,right);
        //递归建立左子树
        root.left=buildTreeHelper(preorder,inorder,left,pos);
        //递归建立右子树
        root.right=buildTreeHelper(preorder,inorder,pos+1,right);
        return root;
    }
    public int find(int toFind, int[] inorder,int left,int right){
        for(int i=left;i<right;i++){
            if(toFind==inorder[i]){
                return i;
            }
        }
        return -1;
    }
}