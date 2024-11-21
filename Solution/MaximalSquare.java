package Solution;

public class MaximalSquare {
    
     /*
     * TC O(n^2)
     * SC O(n^2)
     */

    public int maximalSquare(char[][] matrix) {
        int n =matrix.length;
        int m =matrix[0].length;
        int max =0;
        int[][] dp =new int[n][m];
        for(int i=0;i<n;i++){
            if(matrix[i][0]=='1'){
                dp[i][0]=1;
                max=Math.max(max, dp[i][0]);
            }else{
                dp[i][0]=0;
            }
        }
        for(int j=1;j<m;j++){
            if(matrix[0][j]=='1'){
                dp[0][j]=1;
                max=Math.max(max, dp[0][j]);
            }else{
                dp[0][j]=0;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i][j-1]));
                    max=Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
        
    }
}
