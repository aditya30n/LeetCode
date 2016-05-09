/*
Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length-1;
        return buildTree(inorder, 0, inorder.length-1, postorder);
    }

    int p;

    public TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder) {
        if(iStart > iEnd)
            return null;

        TreeNode node = new TreeNode(postorder[p--]);
        if(iStart == iEnd)
                return node;

        int i = iStart;
        while(inorder[i] != node.val)
            i++;

        node.right = buildTree(inorder, i+1, iEnd, postorder);
        node.left = buildTree(inorder, iStart, i-1, postorder);
        
        return node;
    }
}
