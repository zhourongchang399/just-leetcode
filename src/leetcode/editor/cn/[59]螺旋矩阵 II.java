//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1446 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 模拟顺时针选择的过程。
 * @date: 2025/4/14 15:43
 * @param null
 * @return
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int row = n, col = n;
        int i = 0, j = 0;
        int[][] matrix = new int[row][col];
        int value = 1;
        while (value <= n * n) {
            for (int k = 0; k < col; k++) {
                matrix[i][j++] = value++;
            }
            row--;
            j--;
            i++;
            for (int k = 0; k < row; k++) {
                matrix[i++][j] = value++;
            }
            col--;
            i--;
            j--;
            for (int k = 0; k < col; k++) {
                matrix[i][j--] = value++;
            }
            row--;
            j++;
            i--;
            for (int k = 0; k < row; k++) {
                matrix[i--][j] = value++;
            }
            col--;
            i++;
            j++;
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
