package Solution;

import java.util.*;

public class BackTraking {

    /*
     22. Generate Parentheses

        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     */

    public List<String> generateParenthesis(int n) {
        List<String> ans =new ArrayList<>();
        String st ="";
        generateParenthesis(n,ans,st,0,0);
        return ans;
        
    }

    public void generateParenthesis(int n,List<String> ans,String st,int open,int close) {
        if(open==n && close==n){
            ans.add(st);
            return;
        }

        if(open<n){
            st +="(";
            generateParenthesis(n,ans,st,open+1,close);
            st = st.substring(0, st.length() - 1);
        }

        if(close<open){
            st +=")";
            generateParenthesis(n,ans,st,open,close+1);
            st = st.substring(0, st.length() - 1);
        }
        


    }

    /*
     784. Letter Case Permutation

        Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

        Return a list of all possible strings we could create. Return the output in any order.
     */

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        letterCasePermutation(s, 0, "", result);
        return result;
    }

    public void letterCasePermutation(String s,int ind, String st, List<String> result) {
        if(s.length()==ind){
            result.add(st);
            return;
        }

        char c =s.charAt(ind);
        if(Character.isLetter(c)){
            letterCasePermutation(s,ind+1,st+Character.toLowerCase(c),result);
            letterCasePermutation(s,ind+1,st+Character.toUpperCase(c),result);
        }else{
            letterCasePermutation(s,ind+1,st+c,result);
        }

    }

}
