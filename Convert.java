/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode leftTail=left;
        while(leftTail!=null&&leftTail.right!=null){
            leftTail=leftTail.right;
        }
        //相连
        if(left!=null){
            leftTail.right=pRootOfTree;
            pRootOfTree.left=leftTail;
        }
        TreeNode right=Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right=right;
            right.left=pRootOfTree;
        }
        //返回链表的头节点
        //如果left是空返回的是pRootOfTree
        //如果left不为空返回的是left
        return left==null?pRootOfTree:left;
    }
}