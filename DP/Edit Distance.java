/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

// Using recursion. Exponential complexity
public class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length(), word2.length());   
    }
    
    public int minDistance(String word1, String word2, int m, int n) {
        if(m == 0)
            return n;
            
        if(n == 0)
            return m;
        
        if(word1.charAt(m-1) == word2.charAt(n-1))
            return minDistance(word1.substring(0, m-1), word2.substring(0, n-1));
        else
            return 1 + Math.min(minDistance(word1, word2, m, n-1), 
                       Math.min(minDistance(word1, word2, m-1, n), 
                       minDistance(word1, word2, m-1, n-1)));
    }
}

// Using DP. O(n^2)
public class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length(), word2.length());   
    }
    
    public int minDistance(String word1, String word2, int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++)
            dp[i][0] = i;
            
        for(int i=0; i<=n; i++)
            dp[0][i] = i;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }
        
        return dp[m][n];
    }
}

