
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
            
        ListNode temp1 = head;
        ListNode temp2 = head;
        
        while(temp2 != null && temp2.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next.next;
            
            if(temp1 == temp2)
                break;
        }
        
        if(temp2 == null || temp2.next == null)
            return null;
            
        temp1 = head;
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return temp1;
    }
}
