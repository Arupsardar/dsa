package Solution;

public class FibonacciNumber {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int [] arr =new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
        
    }

    public int[] countBits(int n) {
        int [] ans =new int[n+1];
        for(int i=0;i<=n;i++){
           int count =0;
           int j=i;
           while(j>0){
               int mod =j%2;
               if(mod ==1){
                 count ++;
               }
               n=n/2;
           }
           ans[i]=count;
        }
        return ans;
    }
    //dp
    public int[] countBits2s(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }

    
}
