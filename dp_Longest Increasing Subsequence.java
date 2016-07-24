/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

//O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        for(int i=0; i< nums.length; i++)
            dp[i] = 1;
        
        int max = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j< nums.length; j++){
                if(nums[j] > nums[i] && dp[i]+1 > dp[j]){
                    dp[j] = dp[i]+1;
                    if(dp[j] > max)
                        max = dp[j];
                }
            }
        }
        return max;
    }
}

// O(nlogn)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < dp[0])
                dp[0] = nums[i];
            else if(nums[i] > dp[len-1])
                dp[len++] = nums[i];
            else
                dp[ceilIndex(dp, -1, len-1, nums[i])] = nums[i];
        }
        
        return len;
    }
    
    private int ceilIndex(int[] dp, int start, int end, int key){
        while(end - start > 1){
            int mid = start + (end - start)/2;
            if(dp[mid] >= key)
                end = mid;
            else
                start = mid;
        }
        
        return end;
    }
}

