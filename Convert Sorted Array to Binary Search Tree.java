/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end){
        int mid = start + (end - start)/2;
        
        if(mid < start || mid > end)
            return null;
            
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }
}
