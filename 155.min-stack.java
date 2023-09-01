/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */
import java.util.*;
// @lc code=start
class MinStack {
    List<Integer> stack;
    List<Integer> minValues = new LinkedList<>();
    public MinStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        if (stack.size() == 0 || val <= minValues.get(0)) {
            minValues.add(0, val);
        }
        stack.add(0, val);
    }
    
    public void pop() {
        
        if (stack.get(0).equals(minValues.get(0))) {
            //System.out.println("stack0 = " + stack.get(0) + " min0 = " + minValues.get(0));
            minValues.remove(0);
        }
        stack.remove(0);
        //System.out.println(minValues.toString());
    }
    
    public int top() {
        return stack.get(0);
    }
    
    public int getMin() {
        return minValues.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

