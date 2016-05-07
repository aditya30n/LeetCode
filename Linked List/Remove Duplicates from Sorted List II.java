/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        int val = head.val;
        if(head.next.val == val){
            while(head != null && head.val == val)
                head = head.next;
            return deleteDuplicates(head);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
