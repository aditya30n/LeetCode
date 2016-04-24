/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
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
 
 // Recursive
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new ArrayList<>());
    }
    
    private List<Integer> inorderTraversal(TreeNode root, List<Integer> inOrder) {
        if(root != null){
            inorderTraversal(root.left, inOrder);
            inOrder.add(root.val);
            inorderTraversal(root.right, inOrder);
        }
        return inOrder;
    }
}
