//力扣 205 同构字符串
/*
输入: s = "egg", t = "add"
输出: true
*/ 

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        //正反都来一遍，要不然光判断正的会出现 s="ab",t="aa"也能通过的现象
        return help(s,t)&&help(t,s);
    }
    public boolean help(String s,String t){
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                //主键在map中存在
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{//主键唯一性
            //插入的主键在map中没有存在过
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}