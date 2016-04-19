/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null)
            return levelOrder;
        
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        while(currentLevel.size() > 0){
            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode node : currentLevel){
                if(node.left != null)
                    nextLevel.add(node.left);
                if(node.right != null)
                    nextLevel.add(node.right);
            }
            
            List<Integer> level = new ArrayList();
            for(TreeNode node : currentLevel){
                level.add(node.val);
            }
            levelOrder.add(level);
            currentLevel = nextLevel;
        }
        
        return levelOrder;
    }
}
