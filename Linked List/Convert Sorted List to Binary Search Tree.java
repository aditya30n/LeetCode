/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        this.head = head;
        return sortedListToBST(0, len-1);
    }
    
    private TreeNode sortedListToBST(int start, int end){
        if(start > end)
            return null;
            
        int mid = (start + end)/2;
        
        TreeNode left = sortedListToBST(start, mid-1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        
        head = head.next;
        root.right = sortedListToBST(mid+1, end);
        
        return root;
    } 
}
