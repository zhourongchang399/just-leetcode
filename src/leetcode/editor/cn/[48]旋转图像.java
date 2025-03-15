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
 * @date: 2025/3/15 12:33
 * @param null
 * @return
 */
class Solution {
    public void rotate(int[][] matrix) {

        int i = 0, j = 0;
        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;
        int cycle = 0;
        int swapValue = 0;
        int rotate = 0;

        // 缩圈
        while (cycle < matrix.length / 2) {

            i = rowStart;
            j = colStart;

            // 记录前一个替换的值
            swapValue = 0;

            // 基础初始轮转次数
            rotate = cycle * 2;

            // 轮转次数
            while (rotate < matrix.length - 1) {

                // 从左到右
                while (j <= colEnd) {
                    swapValue = swap(matrix, i, j, swapValue);
                    j++;
                }
                j--;
                i++;

                // 从上到下
                while (i <= rowEnd) {
                    swapValue = swap(matrix, i, j, swapValue);
                    i++;
                }
                i--;
                j--;

                // 从右到左
                while (j >= colStart) {
                    swapValue = swap(matrix, i, j, swapValue);
                    j--;
                }
                j++;
                i--;

                // 从下到上
                while (i >= rowStart) {
                    swapValue = swap(matrix, i, j, swapValue);
                    i--;
                }
                i++;
                j++;

                rotate++;
            }

            while (j < colEnd) {
                int temp = matrix[rowStart][j];
                matrix[rowStart][j] = swapValue;
                swapValue = temp;
                j++;
            }

            cycle++;
            rowEnd--;
            colEnd--;
            rowStart++;
            colStart++;

        }
    }

    private static int swap(int[][] matrix, int i, int j, int swapValue) {
        int temp = matrix[i][j];
        matrix[i][j] = swapValue;
        return temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
