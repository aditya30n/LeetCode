/*
Given a singly linked list, determine if it is a palindrome.
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while(temp2 != null && temp2.next != null){
            temp1 = temp1.next;
            temp2= temp2.next.next;
        }
        
        temp2 = temp1.next;
        temp1.next = null;
        temp2 = reverse(temp2);
        temp1 = head;
        while(temp2 != null){
            if(temp1.val != temp2.val)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return temp1 == null || temp1.next == null;
    }
    
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null)
            return node;
        ListNode rest = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }
}
