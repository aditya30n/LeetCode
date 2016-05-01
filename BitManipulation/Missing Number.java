/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2
*/

// Time: O(n)
// Space: O(1)
public class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for(int i =0; i<nums.length; i++){
            missing ^= i;
            missing ^= nums[i];
        }
        return missing;
    }
}

// Time: O(n)
// Space: O(1)
public int missingNumber(int[] nums) {
	int naturalSum = (nums.length)*(nums.length+1)/2;
	for(int i=0; i<nums.length; i++){
		naturalSum -= nums[i];
	}
	return naturalSum;
}
