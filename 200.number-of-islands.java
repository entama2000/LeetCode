/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
import java.util.*;
// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        printGrid(grid);
        int col = grid[0].length;
        int row = grid.length;
        int[] count = new int[col];
        int ans = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[j][i] == '1') count[i]++;
            }
        }
        while (Arrays.stream(count).sum() != 0) {
            for (int i = 0; i < col; i++) {
                if (count[i] == 0) continue;
                for (int j = 0; j < row; j++) {
                    if (grid[j][i] == '0') continue;
                    island(grid, j, i, count);
                    printGrid(grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void island(char[][] grid, int i, int j, int[] count) {
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        count[j]--;
        if (i - 1 >= 0) island(grid, i - 1, j, count);
        if (j + 1 < grid[0].length) island(grid, i, j + 1, count);
        if (j - 1 >= 0) island(grid, i, j - 1, count);
        if (i + 1 < grid.length) island(grid, i + 1, j, count);
    }
    public void printGrid(char[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
            
        }
        System.out.println("---------");
    }
}
// @lc code=end

