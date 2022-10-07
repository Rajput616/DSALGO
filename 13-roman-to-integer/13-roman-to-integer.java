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
        for(int i = 0; i < s.length()-1; ++i){
            char ch = s.charAt(i);
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                total -= map.get(s.charAt(i));
            } else
                total += map.get(ch);
        }
        return total + map.get(s.charAt(s.length()-1));
        
    }
}

//MCMXCIV // 1000 + 100 - 200 + 1000 = 1900