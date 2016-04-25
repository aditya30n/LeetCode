/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

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
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(root, new ArrayList<>());
    }
    
    private List<Integer> preorderTraversal(TreeNode root, List<Integer> preOrder) {
        if(root != null){
            preOrder.add(root.val);
            preorderTraversal(root.left, preOrder);
            preorderTraversal(root.right, preOrder);
        }
        
        return preOrder;
    }
}

// Iterative
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if(root == null)
            return preOrder;
        
        TreeNode current = root;
        Stack stack = new Stack();
        stack.add(current);
        while(!stack.isEmpty()){
            while(current != null){
                preOrder.add(current.val);
                current = current.left;
                stack.add(current);
            }
            
            current = (TreeNode)stack.pop();
            
            if(current != null){
                current = current.right;
                stack.push(current);
            }
        }
       
        return preOrder;
    }
}
