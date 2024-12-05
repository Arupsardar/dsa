package Solution;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
    
        // Fill the DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base case: If at the first row or first column, there's only one path
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // Sum of paths from the cell above and the cell to the left
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
    
   
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths3(int m, int n) {
        
        return uniquePaths2(0,0,m,n);
        
    }

    public static int uniquePaths2(int cr1, int cr2,int m, int n) {
         if(cr1==m-1 && cr2==n-1){
           
            return 1;
         }
         
            int cu1=0,cu2=0;
            if(cr1<m){
                cu1= uniquePaths2(cr1+1,cr2,m,n);
            }
            if(cr2<n){
                cu2=uniquePaths2(cr1,cr2+1,m,n);
            }
            
            return cu1+cu2;
         
         
         
         
        
    }
    
}
