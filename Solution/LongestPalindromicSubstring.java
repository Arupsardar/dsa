package Solution;

public class LongestPalindromicSubstring {
    
    /*
     * /*
     * TC O(n)
     * SC o(n)
     */

    public String longestPalindrome(String s) {
        int n =s.length();
        if(n<=1){
            return s;
        }

        String ans ="";
        
       
        for(int i=1;i<n;i++){
           int low =i;
           int high=i;
           while(s.charAt(low)==s.charAt(high)){
             low--;
             high++;
             if(low==-1||high==n){
                break;
             }
           } 
           String palidrom =s.substring(low+1, high);
           if(ans.length()<palidrom.length()){
              ans=palidrom;
           }

           low =i-1;
           high=i;
           while(s.charAt(low)==s.charAt(high)){
             low--;
             high++;
             if(low==-1||high==n){
                break;
             }
           } 
           String palidrom2 =s.substring(low+1, high);
           if(ans.length()<palidrom2.length()){
              ans=palidrom2;
           }

        }
        return ans;
    }
}
