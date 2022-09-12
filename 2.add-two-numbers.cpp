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
        long long n1{0}, n2{0};
        ListNode* cur1;
        ListNode* cur2;
        vector<int> l1b; l1b.push_back(l1->val);
        vector<int> l2b; l2b.push_back(l2->val);
        cur1 = l1; cur2 = l2;

        while(cur1->next)
        {
            digit1++;
            cur1 = cur1->next;
            l1b.push_back(cur1->val);
        }
        cur1 = l1;

        while(cur2->next)
        {
            digit2++;
            cur2 = cur2->next;
            l2b.push_back(cur2->val);
        }
        cur2 = l2;

        int digit;
        if(digit1 > digit2)
        {
            for(int i = 0; i < digit1-digit2; i++)
                l2b.push_back(0);
            digit = digit1;
        }
        else
        {
            for(int i = 0; i < digit2-digit1; i++)
                l1b.push_back(0);
            digit = digit2;
        }

        ListNode* Ans = new ListNode();
        ListNode* cur;
        cur = Ans;

        int digitflag = 0;
        int n0 = l1b[0]+l2b[0];
        if(n0 >= 10)
        {
            digitflag = 1;
            cur->val = n0-10;
        }
        else
            cur->val = n0;
        for(int i = 1; i < digit; i++)
        {
            ListNode* ans1 = new ListNode();
            int n = l1b[i]+l2b[i];
            if(digitflag)
            {
                n++;
                digitflag = 0;
            }
            if(n >= 10)
            {
                digitflag = 1;
                ans1->val = n-10;
            }
            else
                ans1->val = n;
            cur->next = ans1;
            cur = cur->next;
        }
        if(digitflag)
        {
            ListNode* ans1 = new ListNode();
            ans1->val = 1;
            cur->next = ans1;
        }
        
        return Ans;
    }

};
// @lc code=end
