package Solution;

public class RotateImage {
    public void rotate(int[][] matrix) {
       
        int n =matrix.length;
        int [][] mati2 =new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mati2[i][j]=matrix[n-j-1][i];
                
            }
           

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=mati2[i][j];
                
            }
           System.out.println(); 

        }
        
    }
        
    
}
