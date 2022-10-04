class Solution {
    Map<String, Integer> map;
    List<List<String>> ans;
    String b;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList();
        Set<String> set = new HashSet(wordList);
        if(!set.contains(endWord)) return ans;
        b = beginWord;
        map = new HashMap();
        Queue<String> q = new LinkedList();
        q.offer(beginWord);
        int size = beginWord.length();
        set.remove(beginWord);
        map.put(beginWord, 0);
        while(!q.isEmpty()){
            String s = q.poll();
            int level = map.get(s);
            if(s.equals(endWord)) break;
            char[] chars = s.toCharArray();
            for(int i = 0; i < size; ++i){
                char ch = chars[i];
                for(char c = 'a'; c <= 'z'; ++c){
                    if(c != ch){
                        chars[i] = c;
                        String curr = new String(chars);
                        if(set.contains(curr)){
                            q.offer(curr);
                            map.put(curr, level+1);
                            set.remove(curr);
                        }
                    }
                }
                chars[i] = ch;
            }
        }
        // System.out.println(map);
        if(map.containsKey(endWord)){
            ArrayList<String> curr = new ArrayList();
            curr.add(endWord);
            dfs(endWord, curr);    
        }
        
        return ans;
    }
    
    void dfs(String word,  List<String> curr){
        if(word.equals(b)){
            ArrayList<String> currAns = new ArrayList(curr);
            Collections.reverse(currAns);
            ans.add(currAns);
            return;
        }
        int len = word.length();
        int steps = map.get(word);
        
        char[] chars = word.toCharArray();
        for(int i = 0; i < len; ++i){
            char ch = chars[i];
            for(char c = 'a'; c <= 'z'; ++c){
                if(c != ch){
                    chars[i] = c;
                    String str = new String(chars);
                    if(map.containsKey(str) && map.get(str) == steps-1){
                        curr.add(str);
                        dfs(str, curr);
                        curr.remove(curr.size()-1);
                    }
                }
            }
            chars[i] = ch;
        }
        
    }
}

/*
    class Solution {
    Map<String, Integer> map;
    List<List<String>> ans;
    String b;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList();
        Set<String> set = new HashSet(wordList);
        if(!set.contains(endWord)) return ans;
        b = beginWord;
        map = new HashMap();
        Queue<Pair<String, Integer>> q = new LinkedList();
        q.offer(new Pair(beginWord, 0));
        set.remove(beginWord);
        map.put(beginWord, 0);
        while(!q.isEmpty()){
            Pair<String, Integer> p = q.poll();
            String s = p.getKey();
            int level = p.getValue();
            if(s.equals(endWord)) break;
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; ++i){
                char ch = chars[i];
                for(char c = 'a'; c < 'z'; ++c){
                    if(c != ch){
                        chars[i] = c;
                        String curr = new String(chars);
                        if(set.contains(curr)){
                            q.offer(new Pair(curr, level+1));
                            map.put(curr, level+1);
                            set.remove(curr);
                        }
                    }
                }
                chars[i] = ch;
            }
        }
        System.out.println(map);
        set = new HashSet(wordList);
        if(!set.contains(beginWord)) set.add(beginWord);
        ArrayList<String> curr = new ArrayList();
        curr.add(endWord);
        dfs(endWord, set, beginWord, ans, curr);
        return ans;
    }
    
    void dfs(String word, Set<String> set, String end, List<List<String>> ans, List<String> curr){
        if(word.equals(end)){
            ArrayList<String> currAns = new ArrayList();
            for(int i = curr.size()-1; i >= 0; --i){
                currAns.add(curr.get(i));
            }
            ans.add(currAns);
            return;
        }
        
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; ++i){
            char ch = chars[i];
            for(char c = 'a'; c <= 'z'; ++c){
                if(c != ch){
                    chars[i] = c;
                    String str = new String(chars);
                    if(set.contains(str) && map.getOrDefault(str, 0) == (map.getOrDefault(word, 0)-1)){
                        curr.add(str);
                        dfs(str, set, end, ans, curr);
                        curr.remove(curr.size()-1);
                    }
                }
            }
            chars[i] = ch;
        }
        
    }
}
*/