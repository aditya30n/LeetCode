/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
 // Using Queue
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        
        Queue<TreeLinkNode> nextLevel;
        while(!currentLevel.isEmpty()){
            nextLevel = new LinkedList();
            while(!currentLevel.isEmpty()){
                TreeLinkNode temp = currentLevel.remove();
                if(temp.left != null)
                    nextLevel.add(temp.left);
                if(temp.right != null)    
                    nextLevel.add(temp.right);
                    
                if(!currentLevel.isEmpty())
                    temp.next = currentLevel.peek();
                else
                    temp.next = null;
            }
            
            currentLevel = nextLevel;
        }
    }
}
