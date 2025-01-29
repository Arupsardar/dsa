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

}
