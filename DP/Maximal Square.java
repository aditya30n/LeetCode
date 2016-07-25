/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
            
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m+1][n+1];
        
        int max = 0;
        for(int i =0; i<=m; i++)
            dp[i][0] = 0;
            
        for(int i =0; i<=n; i++)
            dp[0][i] = 0;
            
        for(int i =1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(matrix[i-1][j-1] == '0')
                    dp[i][j] = 0;
                else{
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                    if(dp[i][j] > max)
                        max = dp[i][j];
                }
            }
        }
        
        return max*max;
    }
    
    private int min(int i, int j, int k){
        if(i <= j && i<= k)
            return i;
        if(j <= i && j <= k)
            return j;
        return k;
    }
}
