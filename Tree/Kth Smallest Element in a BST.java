/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST)
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
 
 // Using inroder traversal O(n)
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack stack = new Stack();
        TreeNode current = root;
        while(current != null){
            stack.add(current);
            current = current.left;
        }
     
        int i =0;
        while(!stack.isEmpty()){
            current = (TreeNode)stack.pop();
            if(++i == k)
                return current.val;
            
            if(current != null)
                current = current.right;
            while(current != null){
                stack.add(current);
                current = current.left;
            }
        }
        return -1;
    }
}
