package datastructure.tree;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class BinaryTree2 {
    public static Node build(){
        //手动添加节点，生成一个树
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node g=new Node('G');
        Node h=new Node('H');
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        e.left=g;
        g.right=h;
        c.right=f;
        return a;
    }

    //先序遍历
    public static void perOrder(Node root){
        if(root==null){
            return;
        }
        //打印根
        System.out.print(root.val+" ");
        //遍历左
        if(root.left!=null){
            perOrder(root.left);
        }
        //遍历右
        if(root.right!=null){
           perOrder(root.right);
        }
    }
    //中序遍历
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        //遍历左
        if(root.left!=null){
            inOrder(root.left);
        }
        //打印根
        System.out.print(root.val+" ");
        //遍历右
        if(root.right!=null){
           inOrder(root.right);
        }
    }
    //后序遍历
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        //遍历左
        if(root.left!=null){
            postOrder(root.left);
        }
        //遍历右
        if(root.right!=null){
            postOrder(root.right);
        }
        //打印根
        System.out.print(root.val+" ");

    }
    //二叉树的节点个数
    public static int size(Node root){
        if(root==null){
            return 0;
        }
        //size=根节点+左子树+右子树
        return 1+size(root.left)+size(root.right);
    }
    //二叉树的叶子节点个数(度为0)
    public static int leafSize(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            //root是叶子节点
            return 1;
        }
        return leafSize(root.left)+leafSize(root.right);
    }
    //二叉树第k层节点个数
    public static int kLevelSize(Node root,int k){
        if(k<1||root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);
    }
    //在二叉树中查找指定元素
    //如果存在，返回该节点的引用
    //如果不存在，返回null
    public static Node find(Node root,char toFind){
        if(root==null){
            return null;
        }
        if(root.val==toFind){
            return root;
        }
        //分别查找左右子树
        Node res=find(root.left,toFind);
        if(res!=null){
            return res;
        }
        return find(root.right,toFind);
    }

    public static void main(String[] args) {
        Node root=build();
        //测试遍历
        System.out.println("先序遍历");
        perOrder(root);
        System.out.println();
        System.out.println("中序遍历");
        inOrder(root);
        System.out.println();
        System.out.println("后序遍历");
        postOrder(root);
        System.out.println();
        //测试二叉树节点个数
        System.out.println("该二叉树的节点个数是"+size(root));
        //测试二叉树叶子结点的个数
        System.out.println("该二叉树叶子节点的个数是"+leafSize(root));
        //测试二叉树第k层节点的个数
        System.out.println("请输入你想知道有多少节点的层数");
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        System.out.println("第"+k+"层有"+kLevelSize(root,k)+"个节点");
        //测试查找节点
        System.out.println("请输入你想查找的节点");
        char f=scanner.next().charAt(0);
        Node res=find(root,f);
        if(res==null){
            System.out.println("没找到该节点");
        }else{
            System.out.println("找到了！"+res);
        }
    }
}
class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
