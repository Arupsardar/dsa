public class Main {
    
    public static void main(String[] args) {
        System.out.println("hello");
       System.out.println(uniquePaths(3,2));
    }

    public static int uniquePaths(int m, int n) {
        int [][] dp =new int[m][n];
        return uniquePaths2(0,0,m,n,dp);
        
    }

    public static int uniquePaths2(int cr1, int cr2,int m, int n,int[][] dp) {
         if(cr1==m-1 && cr2==n-1){
            dp[cr1][cr2]=1;
            return 1;
         }
         if(dp[cr1][cr2]==0){
            int cu1=0,cu2=0;
            if(cr1<m){
                cu1= uniquePaths2(cr1+1,cr2,m,n,dp);
            }
            if(cr2<n){
                cu2=uniquePaths2(cr1,cr2+1,m,n,dp);
            }
            dp[cr1][cr2]=cu1+cu2;
            return cu1+cu2;
         }else{
            return dp[cr1][cr2];
         }
         
         
        
    }

    
}
