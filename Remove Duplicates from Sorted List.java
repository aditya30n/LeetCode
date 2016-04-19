/**

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
            
        ListNode temp = head;
        while(temp.next != null){
            if(temp.next.val == temp.val){
                if(temp.next.next == null)
                    temp.next = null;
                else
                    temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        
        return head;
    }
}