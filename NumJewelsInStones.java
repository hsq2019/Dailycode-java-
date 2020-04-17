class Solution {
    //输入: J = "aA", S = "aAAbbbb"
    //输出: 3
    //set的好处是可以快速判断元素是否在set中存在
    public int numJewelsInStones(String J, String S) {
        Set<Character> set=new HashSet<>();
        int res=0;
        for(char c:J.toCharArray()){
            set.add(c);
        }
        for(char c:S.toCharArray()){
            if(set.contains(c)){
                res++;
            }
        }
        return res;
    }
}