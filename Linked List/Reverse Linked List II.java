/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m > 1){
            head.next = reverseBetween(head.next, --m, --n);
            return head;
        }
        
        ListNode temp = head;
        while(n > 1){
            temp = temp.next;
            n--;
        }
        
        ListNode rest = null;
        if(temp != null){
            rest = temp.next;
            temp.next = null;   
        }
            
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
