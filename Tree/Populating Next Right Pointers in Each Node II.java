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
 
 // Fast approvach
 public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode current = root;
            while(current != null){
                if(current.left != null && current.right != null){
                    current.left.next = current.right;
                    current.right.next = getNextLevelFirst(current.next);
                }
                else if(current.left != null || current.right != null){
                    getNextLevelFirst(current).next = getNextLevelFirst(current.next);
                }
                current = current.next;
            }
            root = getNextLevelFirst(root);
        }
    }
    
    public TreeLinkNode getNextLevelFirst(TreeLinkNode root){
        if(root == null) return null;
        else if(root.left != null) return root.left;
        else if(root.right != null) return root.right;
        else return getNextLevelFirst(root.next);
    }
}
 
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
