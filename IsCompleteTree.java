import java.util.LinkedList;
import java.util.Queue;


//判断二叉树是否是完全二叉树
/*针对一个完全二叉树进行层序遍历会有两个阶段
    阶段1.任何一个节点一定要有两颗子树
        当遇见某个节点只有左子树或者没有子树时切换到第二个阶段
        如果某个节点只有右子树没有左子树，那么绝对不会是完全二叉树
    阶段2.任何一个节点，一定没有子树
    层序遍历完成后，整个树满足要求那么返回ture*/ 

public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root){
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
                    //有左子树和右子树
                    queue.offer(root.left);
                    queue.offer(root.right);
                }else if(root.left==null&&root.right!=null){
                    //没有左子树，有右子树
                    return false;
                }else if(root.left!=null&&root.right==null){
                    //有左子树，没有右子树，要进入第二阶段
                    second=true;
                    queue.offer(root.left);
                }else{
                    //左子树和右子树为空，进入第阶段
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
