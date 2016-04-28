/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length-1);
    }
    
    private int searchInsert(int[] nums, int target, int start, int end) {
    if(end < 0)
        return 0;
    if(target > nums[end])
        return end+1;
    if(start >= end)
        return end;
    int mid = start + (end - start)/2;
    if(target == nums[mid])
        return mid;
    if(target < nums[mid])
        return searchInsert(nums, target, start, mid-1);
    return searchInsert(nums, target, mid + 1, end);
}
}
