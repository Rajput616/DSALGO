class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), max = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0, j = 0; j < len; ++j){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) + 1 > i)  i = map.get(ch) + 1;    
            map.put(ch, j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int len = s.length();
//         Set<Character> set = new HashSet();
//         int i = 0, j = 0, max = 0;
//         while(j < len){
//             char ch = s.charAt(j);
//             if(set.contains(ch)){
//                 while(i < j && set.contains(ch)) {
//                     set.remove(s.charAt(i));
//                     i++;
//                 }
//                 set.add(ch);
//             } else{
//                 set.add(ch);
//                 max = Math.max(max, j-i+1);
//             }
//             j++;
//         }
//         return max;
//     }
// }