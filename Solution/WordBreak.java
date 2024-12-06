package Solution;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set =new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        boolean [] dp =new boolean[301];
        return wordBreakhelper(0,s,set,dp);
 
        
     }
 
     
 
     public static boolean wordBreakhelper(int i,String st,HashSet<String> set,boolean [] dp){
         if(st.length()==i){
             return true;
         }
         if(dp[i] != false){
             return dp[i];
         }
         String temp="";
         for(int j=i;j<st.length();j++){
             temp =temp+st.charAt(j);
             if(set.contains(temp)){
                 if(wordBreakhelper(j+1, st, set,dp)){
                     return dp[i]=true;
                 };
             }
         }
         return dp[i]=false;
     }
 
 
     public static boolean wordBreak2(String s, List<String> wordDict) {
         HashSet<String> set =new HashSet<>();
         for(int i=0;i<wordDict.size();i++){
             set.add(wordDict.get(i));
         }
         
         return wordBreakhelper2s(0,s,set);
  
         
      }
 
      public static boolean wordBreakhelper2s(int i,String st,HashSet<String> set){
         if(st.length()==i){
             return true;
         }
         String temp="";
         for(int j=i;j<st.length();j++){
             temp =temp+st.charAt(j);
             if(set.contains(temp)){
                 if(wordBreakhelper2s(j+1, st, set)){
                     return true;
                 };
             }
         }
         return false;
     }
 
     public boolean wordBreaktrue(String s, List<String> wordDict) {
         HashSet<String> set = new HashSet<>(wordDict);
         int n = s.length();
         boolean[] dp = new boolean[n + 1];
         dp[0] = true; 
 
         for (int i = 1; i <= n; i++) {
             for (int j = 0; j < i; j++) {
                 if (dp[j] && set.contains(s.substring(j, i))) {
                     dp[i] = true;
                     break; 
                 }
             }
         }
         return dp[n];
     }
}
