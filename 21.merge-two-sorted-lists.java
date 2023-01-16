/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val > list2.val) {
                result.val = list2.val;
                list2 = list2.next;
            } else {
                result.val = list1.val;
                list1 = list1.next;
            }
        }
        ListNode ans = result;
        while (list1 != null && list2 != null) {
            ListNode temp = new ListNode();
            System.out.println(list1.val + " " + list2.val);
            if (list1.val > list2.val) {
                temp.val = list2.val;
                if (list2 != null)
                    list2 = list2.next;
            } else {
                temp.val = list1.val;
                if (list1 != null)
                    list1 = list1.next;
            }
            result.next = temp;
            result = result.next;
        }
        while (list1 != null || list2 != null) {
            ListNode temp = new ListNode();
            if (list1 == null) {
                temp.val = list2.val;
                list2 = list2.next;
            } else {
                temp.val = list1.val;
                list1 = list1.next;
            }
            result.next = temp;
            result = result.next;
        }
        return ans;
    }
}
// @lc code=end

