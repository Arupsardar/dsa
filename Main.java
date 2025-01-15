import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    
    public static void main(String[] args) {
      System.out.println(letterCombinations("23"));
      
    }

    public static int reverse(int x) {
        long mul =0;
        int neg =1;
        if(x<0){
            x=x*-1;
            neg =neg *-1;
        }
        while(x>0){
            int mod =x%10;
            x=x/10;
            mul =mul*10+mod;
            if (mul > (Integer.MAX_VALUE - mod) / 10) {
                return 0; 
            }
            
            
        }
        return (int)(mul*neg);
    }

    public static HashMap<Integer,String> map =new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jml");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        System.out.println(map);

        List<String>  ans =new ArrayList<>();
        List<Character> arr=new ArrayList<>();
        letterCombinations(digits,0,arr,ans);
        return ans;
        
    }

    public static void letterCombinations(String digits,int index,List<Character> charList,List<String> ans){
        if(digits.length()==index){
            String result = charList.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());
            ans.add(result);
            return;
        }
        
        int dig =digits.charAt(index)-'0';
        
        String arr=map.get(dig);
        char [] charlist =arr.toCharArray();
        for(int i=0;i<charlist.length;i++){
            charList.add(charlist[i]);
            letterCombinations(digits,index+1,charList,ans);
            charList.remove(charList.size()-1);
        }

    }

    

    
}
