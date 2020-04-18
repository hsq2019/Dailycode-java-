package datastructure.tree;

public class BinarySearchTree {
    public static class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key=key;
        }
    }
    private Node root=null;

    //查找key看是否在二叉搜索树中存在,如果存在就返回
    public Node find(int key){
        Node cur=root;
        while(cur!=null){
            if(cur.key>key){
                //key小就往左子树找
                cur=cur.left;
            }else if(cur.key<key){
                //key大就往右子树找
                cur=cur.right;
            }else{
                //找到了
                return cur;
            }
        }
        return null;
    }

    //插入操作
    //插入不成功返回false，元素重复会插入失败
    public boolean insert(int key){
        //root为空的时候直接插入
        if(root==null){
            root=new Node(key);
            return true;
        }
        Node cur=root;
        Node parent=null;
        while (cur!=null){
            if(key>cur.key){
                parent=cur;
                cur=cur.right;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                return false;
            }
        }
        if(key>parent.key){
            parent.right=new Node(key);
        }else{
            parent.left=new Node(key);
        }
        return true;
    }
    //删除元素key
    public boolean remove(int key){
        if(root==null){
            return false;
        }
        Node parent=null;
        Node cur=root;
        while(cur!=null){
            if(cur.key>key){
                parent=cur;
                cur=cur.left;
            }else if(cur.key<key){
                parent=cur;
                cur=cur.right;
            }else{
                removeNode(parent,cur);
                return true;
            }
        }
        //没找到返回false
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if(cur.left==null){
            //cur的左子树为空的情况
            if(cur==root){
                //如果cur是根节点
                root=cur.right;
            }else if(cur==parent.left){
                parent.left=cur.right;
            }else {
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            //cur的右子树为空
            if(cur==root){
                //如果cur是根节点
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }

        }else {
            //cur的左右子树都不是空
            //1.可以选择找cur左子树的最大的节点作为替罪羊
            //2.也可以选择cur右子树的最小节点作为替罪羊
            //这里选择的是2方法
            Node goatParent=cur;
            Node scapeGoat=cur.right;
            while (scapeGoat!=null){
                //右子树找最小
                goatParent=scapeGoat;
                scapeGoat=scapeGoat.left;
            }
            cur.key=scapeGoat.key;

            if(scapeGoat==goatParent.left){
                goatParent.left=scapeGoat.right;
            }else{
                goatParent.right=scapeGoat.right;
            }
        }
    }

    public static void main(String[] args) {
        //创建一个二叉搜索树
        BinarySearchTree tree=new BinarySearchTree();
        int[] keys={3,9,7,4,1,6,2,8,5};
        for(int key:keys){
            //插入
            tree.insert(key);
        }
        //插入重复数据
        System.out.println(tree.insert(5));
        //中序遍历
        inOrder(tree.root);
        System.out.println();
        //删除
        tree.remove(2);
        inOrder(tree.root);
        System.out.println();
        //查找
        System.out.println(tree.find(9));

    }

    private static void inOrder(Node node) {
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.key+" ");
            inOrder(node.right);
        }

    }


}
