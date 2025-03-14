//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1885 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 按照顺时针遍历矩阵，每遍历完某行或某列，则从记录的剩余行列数中减一，直到行或列为 0，则代表都遍历完矩阵；
 * @date: 2025/3/14 20:15
 * @param null
 * @return
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> res = new ArrayList<Integer>();
        int i = 0, j = 0;

        while (rows > 0 && cols > 0) {
            // 从左到右
            for (int k = 0; k < cols && rows > 0; k++, j++) {
                res.add(matrix[i][j]);
            }
            rows--;
            i++;
            j--;

            // 从上到下
            for (int k = 0; k < rows && cols > 0; k++, i++) {
                res.add(matrix[i][j]);
            }
            cols--;
            j--;
            i--;

            // 从右到左
            for (int k = 0; k < cols && rows > 0; k++, j--) {
                res.add(matrix[i][j]);
            }
            rows--;
            i--;
            j++;

            // 从下到上
            for (int k = 0; k < rows && cols > 0; k++, i--) {
                res.add(matrix[i][j]);
            }
            cols--;
            j++;
            i++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
