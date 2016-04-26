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


//Iterative
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
            
        TreeNode node = root;
        Stack<TreeNode> S = new Stack<TreeNode>();
        S.push(node);
        TreeNode prev = null;
        while (!S.isEmpty()) {
            TreeNode current = S.peek();
 
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    S.push(current.left);
                } else if (current.right != null) {
                    S.push(current.right);
                } else {
                    S.pop();
                    list.add(current.val);
                }
 
            } else if (current.left == prev) {
                if (current.right != null) {
                    S.push(current.right);
                } else {
                    S.pop();
                    list.add(current.val);
                }

            } else if (current.right == prev) {
                S.pop();
                list.add(current.val);
            }
 
            prev = current;
        }
      return list;
    }
      
}
