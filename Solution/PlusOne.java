package Solution;

import java.util.*;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> arr =new ArrayList<>();
        int carray=0;
        
        for(int i=digits.length-1;i>=0;i--){
            int sum=0;
            if(i==digits.length-1){
               sum =digits[i]+carray+1;
            }else{
                sum =digits[i]+carray;
            }

            arr.add(sum%10);
            carray=sum/10;
            
        }
        if(carray>0){
            arr.add(carray);
        }

        int[] ans=new int[arr.size()];
        int ind=0;
        for(int i=arr.size()-1;i>=0;i--){
           ans[ind]=arr.get(i);
           ind++;
        }

        return ans;

    }
}
