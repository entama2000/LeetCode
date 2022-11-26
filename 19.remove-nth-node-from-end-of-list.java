/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 1;
        ListNode temp1 = head;
        while (temp1.next != null) {
            temp1 = temp1.next;
            sz++;
        }
        //System.out.println(sz);
        ListNode temp = new ListNode(-1, head);
        for (int i = 0; i < sz - n; i++) {
            temp = temp.next;
        }
        if (temp.next.next == null && sz != n) {
            temp.next = null;
        } else if (sz == n) {
            head = head.next;
        } else {
            //System.out.println(temp.next.next.val);
            ListNode tempRemove = temp.next;
            temp.next = tempRemove.next;
            tempRemove.next = null;
        }   
        return head;
    }
}
// @lc code=end

