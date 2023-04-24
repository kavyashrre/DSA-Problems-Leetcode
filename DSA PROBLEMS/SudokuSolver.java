class Solution {
    public void solveSudoku(char[][] board) {
         boolean ans = solve(board);   
    }
   
    public static boolean solve(char[][] board) {
        int n = board.length;
        int r = -1;
        int c = -1;
        boolean notempty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    r = i;
                    c = j;
                    notempty = false;
                    break;

                }

            }
            if (notempty == false) {
                break;
            }
        }
        if (notempty) {
            return true;
        }
        for (char num = '1'; num <= '9'; num++) {

            if (isSafe(board, r, c, num)) {
                board[r][c]=num;
                if (solve(board)) {

                    return true;
                } else {
                    board[r][c] = '.';
                }
            }
        }
        return false;


    }

    public static boolean isSafe(char[][] board, int r, int c, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == num) {
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
        int startrow = r - r % sqrt;
        int startcol = c - c % sqrt;
        for (int i = startrow; i < startrow + sqrt; i++) {
            for (int j = startcol; j < startcol + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
        
    }
}