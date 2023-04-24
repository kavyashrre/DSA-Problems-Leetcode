class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int top=0, left=0, down=mat.length-1, right=mat[0].length-1;
        int count=1;
        while(top<=down && left<=right){
            
            for(int i=left; i<=right; i++){               
                mat[top][i]=count;
                count++;
            }
            top++;
        
            for(int i=top; i<=down; i++){
                mat[i][right]=count;
                count++;
            }
            right--;
        
            if(top<=down){
                for(int i=right; i>=left; i--){
                    mat[down][i]=count;
                    count++;
                }
                down--;
            }
            if(left<=right){
                for(int i=down; i>=top; i--){
                    mat[i][left]=count;
                    count++;
                }
                left++;
            }
        }
        return mat;
    }
}