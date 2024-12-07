package Solution;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char [] word_arr =word.toCharArray();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word_arr[0] && isexist(board,i,j,n,m,0,word_arr)){
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean isexist(char[][] board,int i,int j,int n,int m,int index,char[] word_arr){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='*'||board[i][j] !=word_arr[index]){
            return false;
        }
        if(index ==word_arr.length-1){
            return true;
        }
        char ch =board[i][j];
        
        board[i][j]='*';
        boolean res =isexist(board, i-1, j, n, m, index+1, word_arr)||
        isexist(board, i+1, j, n, m, index+1, word_arr)||
        isexist(board, i, j-1, n, m, index+1, word_arr)||
        isexist(board, i, j+1, n, m, index+1, word_arr);
        board[i][j]=ch;
        return res;

    }
}
