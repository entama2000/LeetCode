/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidCol(board, i)) {
                return false;
            }
            if (!isValidRow(board, i)) {
                return false;
            }
            if (!isValidSquare(board, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean isValidCol(char[][] board, int col) {
        int[] a = new int[10];
        for (int i = 0; i < 9; i++) {
            if (board[col][i] == '.') {
                continue;
            } else if (a[(board[col][i] - '0')] > 0) {
                return false;
            } else {
                a[(board[col][i] - '0')] = 1;
            }
        }
        return true;
    }
    private boolean isValidRow(char[][] board, int row) {
        int[] a = new int[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][row] == '.') {
                continue;
            } else if (a[(board[i][row] - '0')] > 0) {
                return false;
            } else {
                a[(board[i][row] - '0')] = 1;
            }
        }
        return true;
    }
    private boolean isValidSquare(char[][] board, int num) {
        int[] a = new int[10];
        for (int i = 0; i < 9; i++) {
            int col = (num % 3) * 3;
            int row = (num / 3) * 3;
            col += i % 3;
            row += i / 3;
            if (board[col][row] == '.') {
                continue;
            } else if (a[(board[col][row] - '0')] > 0) {
                return false;
            } else {
                a[(board[col][row] - '0')] = 1;
            }
        }
        return true;
    }
}
// @lc code=end

