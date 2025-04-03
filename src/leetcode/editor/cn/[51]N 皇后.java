//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2283 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 矩阵记录当前皇后的分布以供每次判断是否符合放置条件；
 *               符合则放置并记录当前 String，递归到下一行；
 *               不符合则跳过，假如该行位置都不符合则回溯到上一行，重新开始搜寻下一位置；
 *               最终回溯到第一行，最后一列则结束该程序。
 * @date: 2025/4/3 16:24
 * @param null
 * @return
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[][] board = new int[n][n];
        List<String> current = new ArrayList<>();
        mySolveNQueens(board, res, current, 0);
        return res;
    }

    private void mySolveNQueens(int[][] board, List<List<String>> res, List<String> current, int row) {
        if (row == board.length) {
            res.add(new ArrayList<String>(current));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (solve(board, row, col)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < board.length; i++) {
                    if (i == col) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                current.add(sb.toString());
                board[row][col] = 1;
                mySolveNQueens(board, res, current, row + 1);
                board[row][col] = 0;
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean solve(int[][] board, int row, int col) {
        for (int i = row - 1, j = 1; i >= 0; i--, j++) {
            if (board[i][col] == 1) {
                return false;
            }
            if (col + j < board[0].length && board[i][col + j] == 1) {
                return false;
            }
            if (col - j >= 0 && board[i][col - j] == 1) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
