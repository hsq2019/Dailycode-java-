/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
//力扣 690
//给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id
//输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//输出: 11
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //使用hashmap来解
        Map<Integer,Employee> map=new HashMap<>();
        //循环把链表中的值存到map中
        for(Employee e:employees){
            map.put(e.id,e);
        }
       return help(map,id);
    }
    public int help(Map<Integer,Employee> map,int id){
        Employee employee=map.get(id);
        int res=employee.importance;
        for(int i=0;i<employee.subordinates.size();i++){
            Integer subId=employee.subordinates.get(i);
            //递归
            res+=help(map,subId);
        }
        return res;
    }
}