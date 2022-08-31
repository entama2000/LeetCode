/*
 * @lc app=leetcode id=2 lang=cpp
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int digit1=1, digit2=1;
        int n1{0}, n2{0};
        ListNode* cur1;
        ListNode* cur2;
        cur1 = l1; cur2 = l2;
        while(cur1->next)
        {
            digit1++;
            cur1 = cur1->next;
        }
        cur1 = l1;
        for(int i = 0; i < digit1; i++)
        {
            n1 += (cur1->val)*pow(10, i);
            if(cur1->next)
                cur1 = cur1->next;
        }
        cout << n1;
        return l1;
    }
};
// @lc code=end

