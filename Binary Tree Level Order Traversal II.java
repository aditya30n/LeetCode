/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> reverseOrder = new ArrayList<>();
        if(root == null)
            return reverseOrder;
        Stack st = new Stack();
   
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while(level.size() > 0){
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            for(TreeNode node : level){
                curr.add(node.val);
                if(node.left != null)
                    nextLevel.add(node.left);
                if(node.right != null)
                    nextLevel.add(node.right);
            }
            st.push(curr);
            level = nextLevel;
        }
        
        while(!st.isEmpty()){
            reverseOrder.add((List)st.pop());
        }
        
        return reverseOrder;
    }
}
