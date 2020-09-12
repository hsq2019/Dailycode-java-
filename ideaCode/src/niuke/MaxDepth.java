package niuke;


import java.util.LinkedList;
import java.util.Queue;

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
    public int maxDepth1(TreeNode root){
        int res=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
