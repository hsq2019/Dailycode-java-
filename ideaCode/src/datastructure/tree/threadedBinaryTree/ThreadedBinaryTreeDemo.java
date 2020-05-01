package datastructure.tree.threadedBinaryTree;


import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

//线索化二叉树
//在原先二叉树的基础上增加了线索话的功能
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root=new HeroNode(1,"A");
        HeroNode node2=new HeroNode(3,"B");
        HeroNode node3=new HeroNode(6,"C");
        HeroNode node4=new HeroNode(8,"D");
        HeroNode node5=new HeroNode(10,"E");
        HeroNode node6=new HeroNode(14,"F");

        //手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree=new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        HeroNode leftNode=node5.getLeft();
        HeroNode rightNode=node5.getRight();
        System.out.println("10号节点的前驱节点是"+leftNode);
        System.out.println("10号节点的后继节点是"+rightNode);
        //遍历
        threadedBinaryTree.threadedList();

    }
    
}

class ThreadedBinaryTree{
    private HeroNode root;
    //prev始终保留前一个节点，在递归线索化时
    private HeroNode prev=null;
    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }
    //编写二叉树线索话的方法
    //node是当前需要线索化的节点
    public void threadedNodes(HeroNode node){
        if(node==null){
            return;
        }
        //终须遍历线索化
        //1,先线索化左子树
        threadedNodes(node.getLeft());
        //2，线索化当前节点
        if(node.getLeft()==null){
            node.setLeft(prev);
            node.setLeftType(1);
        }
        if(prev!=null&&prev.getRight()==null){
            prev.setRight(node);
            prev.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱结点
        prev=node;

        //3.线索化右子树
        threadedNodes(node.getRight());
    }
    //遍历线索化二叉树(中序)
    public void threadedList(){
        HeroNode cur=root;
        //先找到被线索化的一个节点(标记)
        while (cur!=null){
            while (cur.getLeftType()==0){
                cur=cur.getLeft();
            }
            //打印当前节点
            System.out.println(cur);
            //如果右边也被标记，说明当前节点是没有右子树
            while (cur.getRightType()==1){
                cur=cur.getRight();
                System.out.println(cur);
            }
            //有右子树的情况
            cur=cur.getRight();
        }
    }

    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //left type是0 那么指向左子树，是1指向前驱
    //right type是0 那么指向右子树，是1指向后继
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历的方法
    public void preOrder(){
        System.out.println(this);
        //如果左子树不为空，递归左子树前序遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        //如果右子树不是空，递归右子树前序遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        //如果左子树不为空，递归左子树中序遍历
        if(this.left!=null){
            this.left.infixOrder();
        }
        //输出该节点(父节点)
        System.out.println(this);
        //如果右子树不为空，递归右子树中序遍历
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        //如果左子树不为空，递归左子树中序遍历
        if(this.left!=null){
            this.left.postOrder();
        }
        //如果右子树不为空，递归右子树中序遍历
        if(this.right!=null){
            this.right.postOrder();
        }
        //输出该节点
        System.out.println(this);
    }
}

