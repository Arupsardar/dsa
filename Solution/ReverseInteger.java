package Solution;

public class ReverseInteger {
    public int reverse(int x) {

        int mul =0;
        int neg =1;
        if(x<0){
            x=x*-1;
            neg =neg *-1;
        }
        while(x>0){
            int mod =x%10;
            if (mul > (Integer.MAX_VALUE - mod) / 10) {
                return 0; 
            }
            
            mul =mul*10+mod;
            x=x/10;
            
            
        }
        return mul*neg;
    }
}
