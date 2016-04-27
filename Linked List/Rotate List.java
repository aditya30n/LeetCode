/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
    if(k == 0 || head == null || head.next == null)
        return head;

    ListNode temp1 = head;
    for(int i=0; i<k; i++){
        if(temp1 != null)
            temp1 = temp1.next;
        else
            return rotateRight(head, k%i);
    }

    if(temp1 == null)
        return head;

    ListNode temp2 = head;
    while(temp1.next != null){
        temp2 = temp2.next;
        temp1 = temp1.next;
    }

    ListNode headNode = temp2.next;
    temp2.next = null;
    temp1.next = head;

    return headNode;
}
}
