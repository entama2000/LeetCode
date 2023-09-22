/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */
import java.util.*;
// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> mp = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            double time = (target - position[i]) * 1.0 / speed[i];
            mp.put(Integer.valueOf(position[i]), Double.valueOf(time));
        }
        double min = Double.MAX_VALUE;
        int cursp = Integer.MAX_VALUE;
        int fleet = 0;
        Stack<Double> st = new Stack<>();
        for (Integer key : mp.keySet()) {
            int pos = key;
            double time = mp.get(key);
            //System.out.print("pos: " + pos + " time " + time + " \n");
            if (time < min) {
                //System.out.println("in if statement");
                fleet++;
                min = time;
                st.push(time);
            } else {
                min = Math.max(min, time);
                while (!st.isEmpty()) {
                    if (st.peek() <= min) {
                        st.pop();
                        fleet--;
                    } else {
                        break;
                    }
                }
                st.push(min);
            }
            //System.out.println(st.size());
            //mp.remove(key);
        }
        return st.size();
    }
}
// @lc code=end

