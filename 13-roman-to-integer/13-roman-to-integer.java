class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int total = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(i > 0 && map.get(s.charAt(i-1)) < map.get(ch)){
                total -= 2 * map.get(s.charAt(i-1));
            }
            total += map.get(ch);
        }
        return total;
        
    }
}