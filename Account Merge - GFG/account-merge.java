//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java
class DSU{
    int[] parent, rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; ++i) parent[i] = i;
    }
    
    public int findPar(int u){
        if(u == parent[u]) return u;
        return parent[u] = findPar(parent[u]);
    }
    
    public void union(int u, int v){
        int ultU = findPar(u);
        int ultV = findPar(v);
        if(ultU == ultV) return;
        if(rank[ultU] < rank[ultV]){
            parent[ultU] = ultV;
        } else{
            parent[ultV] = ultU;
            rank[ultU]++;
        }
    }
}


class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
     int n = accounts.size();
    DSU dsu = new DSU(n);
    Map<String, Integer> map = new HashMap();
    for(int i = 0; i < n; ++i){
        for(int j = 1; j < accounts.get(i).size(); ++j){
            String s = accounts.get(i).get(j);
            if(map.containsKey(s))  dsu.union(map.get(s), i);
            else  map.put(s, i);
        }
    }
    Map<Integer, List<String>> mainMap = new HashMap();
    for(String key : map.keySet()){
        int index = map.get(key);
        int parentIndex = dsu.findPar(index);
        List<String> list = mainMap.getOrDefault(parentIndex, new ArrayList());
        list.add(key);
        mainMap.put(parentIndex, list);
    }
    
    List<List<String>> ans = new ArrayList();
    for(int key : mainMap.keySet()){
        List<String> list = mainMap.get(key);
        Collections.sort(list);
        List<String> curr = new ArrayList();
        curr.add(accounts.get(key).get(0));
        curr.addAll(list);
        ans.add(curr);
    }
    return ans;
  }
}
     