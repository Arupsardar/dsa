import java.lang.annotation.Target;
import java.util.*;



public class Main {
    
    public static void main(String[] args) {
      int n =-2147483412; 
      System.out.println(reverse(n)); 
      
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

    

    
}
