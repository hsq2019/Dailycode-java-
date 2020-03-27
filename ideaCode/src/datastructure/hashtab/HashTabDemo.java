package datastructure.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab=new HashTab(7);

        //简单菜单
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员信息");
            System.out.println("delete:删除雇员信息");
            System.out.println("exit:退出系统");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入姓名");
                    String name=scanner.next();
                    Emp emp=new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入你想查找的雇员id");
                    int id1=scanner.nextInt();
                    hashTab.findEmpByID(id1);
                    break;
                case "delete":
                    System.out.println("请输入你想删除的雇员id");
                    int id2=scanner.nextInt();
                    hashTab.delEmpByID(id2);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }
    }





    //创建哈希表，管理多条链表
    static class HashTab{
        private EmpLinkedList[] empLinkedListArray;
        private int size;//表示右多少条链表
        //构造
        public HashTab(int size) {
            //初始化
            this.size=size;
            empLinkedListArray = new EmpLinkedList[size];
            //初始化每条链表
            for(int i=0;i<size;i++){
                empLinkedListArray[i]=new EmpLinkedList();
            }
        }
        //添加雇员
        public void add(Emp emp){
            //根据员工id得到该员工应当加入到那条链表
            int emLinkedListNO=hashFun(emp.id);
            empLinkedListArray[emLinkedListNO].add(emp);
        }
        //遍历哈希表
        public void list(){
            for(int i=0;i<size;i++){
                empLinkedListArray[i].list(i);
            }
        }
        //根据输入的id查找雇员
        public void findEmpByID(int id){
            int emLinkedListNO=hashFun(id);
            Emp emp=empLinkedListArray[emLinkedListNO].findEmpById(id);
            if(emp!=null){
                System.out.println("在第"+(emLinkedListNO+1)+"条链表中找到该雇员"+emp);
            }else{
                System.out.println("在哈希表中没有找到雇员");
            }
        }
        //根据id删除雇员信息
        public void delEmpByID(int id){
            int emLinkedListNO=hashFun(id);
            empLinkedListArray[emLinkedListNO].delEmpById(id);
        }

        //编写散列反法，取模法
        public int hashFun(int id){
            return id%size;
        }


    }







    //表示一个雇员,一个节点
    static class Emp{
        public int id;
        public String name;
        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }






    //创建一个EmpLinkedList，表示一条链表
    static class EmpLinkedList{
        //头指针,没有傀儡节点
        private Emp head=null;

        //添加雇员
        //添加雇员时，id自增，相当于尾插
        public void add(Emp emp){
            //如果添加第一个雇员
            if(head==null){
                head=emp;
                return;
            }
            Emp curEmp=head;
            while (curEmp.next!=null){
                curEmp=curEmp.next;
            }
            curEmp.next=emp;
        }

        //遍历链表
        public void list(int no){
            if(head==null){
                System.out.println("第"+(no+1)+"条链表为空");
                return;
            }
            System.out.print("第"+(no+1)+"条链表信息为：");
            Emp curEmp=head;
            while (curEmp!=null){
                System.out.print(curEmp+" ");
                curEmp=curEmp.next;
            }
            System.out.println();
        }
        //根据id查找雇员
        //如果查找到了，那么返回Emp.
        //如果没有查到，返回null
        public Emp findEmpById(int id){
            //判断链表是否为空
            if(head==null){
                System.out.println("链表为空");
                return null;
            }
            Emp curFind=head;
            while (curFind!=null){
                if(curFind.id==id){
                    return curFind;
                }
                curFind=curFind.next;
            }
            return null;
        }
        //根据id删除雇员信息
        public void delEmpById(int id){
            if(head==null){
                System.out.println("当前链表为空！无法进行删除操作");
                return;
            }
            Emp prev=head;
            Emp cur=prev.next;
            while (cur!=null){
                if(cur.id==id){
                    prev.next=cur.next;
                    cur=prev.next;
                }else{
                    prev=cur;
                    cur=cur.next;
                }
            }
            if(head.id==id){
                head=head.next;
            }
            System.out.println("删除成功！");
        }

    }
}
