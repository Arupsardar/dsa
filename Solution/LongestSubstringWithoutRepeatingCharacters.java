package Solution;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
     * /*
     * TC O(n)
     * SC o(n)
     */
     
    public int lengthOfLongestSubstring(String s) {
        int maxlen =0;
         HashSet<Character> set =new HashSet<>();
         int i=0,j=0;
         int n =s.length();
         while(j<s.length()){
             char ch =s.charAt(j);
             if(set.contains(ch)){
                 while(set.contains(ch)){
                     set.remove(s.charAt(i));
                     i++;
                 }
                 set.add(ch);
                 j++;
             }else{
                 set.add(ch);
                 j++;
                 maxlen =Math.max(maxlen, set.size());
             }
             
         }
         return maxlen;
     }
}
