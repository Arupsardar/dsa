package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {

    class Pair{
        int fr;
        int sc;
        public Pair(int fr,int sc){
            this.fr=fr;
            this.sc=sc;
        }
    }

    public void dfs(int row,int col, char [][] grid,int [][] vit){
        vit[row][col]=1;
        Queue<Pair> qu =new LinkedList<>();
        qu.add(new Pair(row, col));
        int n =grid.length;
        int m =grid[0].length;

        int[][] tri ={{-1,0},{0,+1},{+1,0},{0,-1}};
        
        while(!qu.isEmpty()){
            int r =qu.peek().fr;
            int c =qu.peek().sc;
            qu.remove();
            for(int i=0;i<tri.length;i++){
                int nrow=r+tri[i][0];
                int ncol=c+tri[i][1];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vit[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                    vit[nrow][ncol]=1;
                    qu.add(new Pair(nrow, ncol)); 
                }
            }

        }

    }

    public int numIslands(char[][] grid) {
        int count =0;
        int n =grid.length;
        int m =grid[0].length;
        int [][] vit =new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(vit[i][j]+" ");
                if(vit[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid,vit);
                }
                System.out.println();
            }
        }
        return count;
        
    }
}
