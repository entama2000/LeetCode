/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int l = 0;
        int r = 0;
        int[] tarray = new int[60];
        int[] sarray = new int[60];
        for (int i = 0; i < t.length(); i++) {
            tarray[cint(t.charAt(i))] += 1;
        }
        boolean allflag = true;
        for (int i = 0; i < s.length(); i++) {
            if (tarray[cint(s.charAt(i))] < 1) continue;
            sarray[cint(s.charAt(i))] += 1;
            if (sarray[cint(s.charAt(i))] == tarray[cint(s.charAt(i))]) {
                boolean flag = true;
                for (int j = 0; j < tarray.length; j++) {
                    if (sarray[j] < tarray[j]) flag = false;
                }
                if (flag) {
                    allflag = false;
                    r = i;
                    break;
                }
            }
        }
        if (!s.equals(t) && r == 0 && allflag) {
            return "";
        }

        int lans = l;
        int rans = r;
        int maxlen = r - l + 1;
        
        while (r < s.length()) {
            boolean flag = true;
            while (flag) {
                if (tarray[cint(s.charAt(l))] < 1) {
                    l++;
                } else if (sarray[cint(s.charAt(l))] - 1 < tarray[cint(s.charAt(l))]) {
                    //System.out.println("flag = false l: " + l + " tarray[B] = " + tarray[1]);
                    flag = false;
                } else {
                    sarray[cint(s.charAt(l))] -= 1;
                    l++;
                }
            }
            
            if (r - l + 1 < maxlen) {
                maxlen = r - l + 1;
                lans = l;
                rans = r;
            }
            System.out.println("maxlen: " + maxlen + " lans: " + lans + " rans: " + rans);

            flag = true;
            r++;
            while (flag && r < s.length()) {
                if (tarray[cint(s.charAt(r))] < 1) {
                    r++;
                    continue;
                }
                sarray[cint(s.charAt(r))] += 1;
                flag = false;
            }
            //System.out.println("len: " + (r - l + 1) + " l: " + l + " r: " + r);
            //System.out.println("maxlen: " + maxlen + " lans: " + lans + " rans: " + rans);
        }
        return s.substring(lans, rans + 1);
    }

    //char to int
    private int cint(char c) {
        int num = c - 'A';
        if (num < 26) {
            return num;
        } else {
            return (int)(c - 'a' + 26);
        }
    }
}
// @lc code=end

