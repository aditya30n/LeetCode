/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code"
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!dp[i] && wordDict.contains(s.substring(0,i+1))){
                    dp[i] = true;
            }
                
            if(dp[i]){
                for(int j = i+1; j<n; j++){
                    if(!dp[j] && wordDict.contains(s.substring(i+1, j+1)))
                        dp[j] = true;
                }   
            }
            
            if(dp[n-1])
                return true;
        }
        
        return dp[n-1];
    }
}
