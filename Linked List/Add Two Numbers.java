/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1,l2, 0);
}

private ListNode addTwoNumbers(ListNode l1, ListNode l2, int quote) {
    if(l1 == null && l2 == null){
        if(quote == 0)
            return null;
        return new ListNode(quote);
    }
    if(l1 == null){
        if(quote == 0)
            return l2;
        ListNode node = new ListNode((l2.val + quote)%10);
        node.next = addTwoNumbers(l1, l2.next, (l2.val + quote)/10);
        return node;
    }

    if(l2 == null){
        return addTwoNumbers(l2,l1, quote);
    }

    int sum = (l1.val + l2.val + quote)%10;
    quote = (l1.val + l2.val + quote)/10;

    ListNode node = new ListNode(sum);
    node.next = addTwoNumbers(l1.next, l2.next, quote);
    
    return node;
}
}
