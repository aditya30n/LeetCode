/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

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
 
 //Recursion
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversal(root, new ArrayList<Integer>());
    }
    
    private List<Integer> postorderTraversal(TreeNode root, List<Integer> postOrder) {
        if(root != null){
            postorderTraversal(root.left, postOrder);
            postorderTraversal(root.right, postOrder);
            postOrder.add(root.val);
        }
        
        return postOrder;
    }
}
