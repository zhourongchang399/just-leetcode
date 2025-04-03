//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 深度优先搜索 数组 字符串 回溯 矩阵 👍 1970 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 搜索全部答案空间，遇到不符合条件就回溯，通过一个 visited[][] 记录当前路径防止重走，遍历矩阵即可。
 * @date: 2025/4/3 13:34
 * @param null
 * @return
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                res = myExist(board, word, i, j, 0, visited) ? true : res;
                visited[i][j] = false;
            }
        }
        return res;
    }

    private boolean myExist(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index + 1 == word.length() && board[i][j] == word.charAt(index)) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }

        boolean left = false, right = false, up = false, down = false;

        // turn left
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            left = myExist(board, word, i, j - 1, index + 1, visited);
            if (!left) {
                visited[i][j - 1] = false;
            }
        }

        // turn right
        if (j + 1 < board[0].length && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            right = myExist(board, word, i, j + 1, index + 1, visited);
            if (!right) {
                visited[i][j + 1] = false;
            }
        }

        // turn up
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            up = myExist(board, word, i - 1, j, index + 1, visited);
            if (!up) {
                visited[i - 1][j] = false;
            }
        }

        // turn down
        if (i + 1 < board.length && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            down = myExist(board, word, i + 1, j, index + 1, visited);
            if (!down) {
                visited[i + 1][j] = false;
            }
        }

        if (left || right || up || down) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
