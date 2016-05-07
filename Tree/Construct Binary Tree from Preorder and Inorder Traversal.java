/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        p =0;
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }
    
    int p;
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int iStart, int iEnd) {
        if(iStart > iEnd)
            return null;
        
        TreeNode node = new TreeNode(preorder[p++]);
        if(iStart == iEnd)
            return node;
        
        int i = iStart;
        while(inorder[i] != node.val)
            i++;
            
        node.left = buildTree(preorder, inorder, iStart, i-1);
        node.right = buildTree(preorder, inorder, i+1, iEnd);
        return node;
    }
}
