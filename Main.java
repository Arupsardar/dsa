import java.util.*;

import Solution.WordBreak;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("hello");
       
    }

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
        if(dp[i]){
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

    
}
