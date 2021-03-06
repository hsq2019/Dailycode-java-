package winter_homework;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import sun.invoke.empty.Empty;

import java.util.LinkedList;
import java.util.Queue;


public class TestClass {
    public boolean isCompleteTree(TreeNode root){
        //第二阶段
        if(root==null){
            return true;
        }
        boolean second=false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(!second){
                //第一阶段
                if(root.left!=null&&root.right!=null){
                    queue.offer(root.left);
                    queue.offer(root.right);
                }else if(root.left==null&&root.right!=null){
                    return false;
                }else if(root.left!=null&&root.right==null){
                    second=true;
                    queue.offer(root.left);
                }else{
                    second=true;
                }
            }else{
                //第二阶段
                if(cur.left!=null||cur.right!=null){
                    return false;
                }
            }
        }
        return true;
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
