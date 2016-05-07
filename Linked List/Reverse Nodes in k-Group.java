/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for(int i=1; i< k && temp != null; i++){
            temp = temp.next;
        }
        
        if(temp == null)
                return head;
        
        ListNode rest = reverseKGroup(temp.next, k);
        temp.next = null;
        temp = reverse(head);
        head.next = rest;
        return temp;
    }
    
    private ListNode reverse(ListNode node){
        if(node == null || node.next == null)
            return node;
            
        ListNode rest = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }
}
