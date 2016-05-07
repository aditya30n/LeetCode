/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
 
 // O(n)
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode node){
        if(node == null)
            return 0;
        
        int left = height(node.left);
        int right = height(node.right);
        
        if(Math.abs(left - right)> 1 || left == -1 || right == -1)
            return -1;
        return 1 + Math.max(left, right);
    }
}
 
 
 // O(n^2)
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode node){
        if(node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
