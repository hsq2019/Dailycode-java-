package classdemo;

import java.util.Scanner;

public class BuildTree {
    static class TreeNode{
        public char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //循环输入
        while (scanner.hasNext()){
            String line=scanner.next();
            //先把二叉树按照前序遍历建立出来
            TreeNode root=build(line);
            //中序遍历
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left!=null){
            inOrder(root.left);
        }
        System.out.print(root.val+" ");
        if(root.right!=null){
            inOrder(root.right);
        }
    }
    //按照先序遍历建立树
    //用一个数字记录访问前序遍历字符串到第几位了
    private static int index=0;
    private static TreeNode build(String line) {
        index=0;
        //借助一个方法去完成递归
        return creatTree(line);
    }

    private static TreeNode creatTree(String line) {
        char cur=line.charAt(index);
        if(cur=='#'){
            return null;
        }
        //构建一个节点
        TreeNode root=new TreeNode(cur);
        index++;
        root.left=creatTree(line);
        index++;
        root.right=creatTree(line);
        return root;
    }
}
