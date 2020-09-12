package niuke;



class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
 }

public class MaxDepth {
    public int maxDepth (TreeNode root) {
        // write code here
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
