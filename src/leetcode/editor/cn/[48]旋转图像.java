//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 2028 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 原地算法，轮转矩阵只需要遍历外一个外层，每个值轮转 matrix.lenght - 1 次，并缩圈，一共只需要轮转 matrix.lenght / 2 次即可；
 *               第二个办法，观察轮转的位置，即为每个值轮转 matrix.lenght - 1 次，行只需 matrix.length / 2 和列只需 (matrix.length + 1) / 2 位置的值，
 *               轮转 matrix.lenght - 1 个位置即可；
 * @date: 2025/3/15 12:33
 * @param null
 * @return
 */
class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < (matrix.length + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
