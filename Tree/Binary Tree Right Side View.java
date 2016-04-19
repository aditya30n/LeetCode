/* 
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if(root == null)
            return rightSide;
        
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
            
            rightSide.add(currentLevel.get(currentLevel.size()-1).val);
            currentLevel = nextLevel;
        }
        return rightSide;
    }
    
}
