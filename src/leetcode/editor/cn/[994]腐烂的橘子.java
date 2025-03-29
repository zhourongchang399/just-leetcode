//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 1000 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 采用广度优先遍历，使用队列记录当前时间点的烂橘子，出队则将其周围好橘子腐烂并入队，更新时间即可；
 *               需要注意，初始的三个情况，（1）没有橘子：0，（2）只有烂橘子：0，（3）只有好橘子：-1.
 * @date: 2025/3/29 13:07
 * @param null
 * @return
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        int count = 0;
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            flag = false;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] + 1 < grid.length && grid[cur[0] + 1][cur[1]] == 1) {
                    grid[cur[0] + 1][cur[1]] = 2;
                    queue.add(new int[]{cur[0] + 1, cur[1]});
                }
                if (cur[0] - 1 >= 0 && grid[cur[0] - 1][cur[1]] == 1) {
                    grid[cur[0] - 1][cur[1]] = 2;
                    queue.add(new int[]{cur[0] - 1, cur[1]});
                }
                if (cur[1] + 1 < grid[0].length && grid[cur[0]][cur[1] + 1] == 1) {
                    grid[cur[0]][cur[1] + 1] = 2;
                    queue.add(new int[]{cur[0], cur[1] + 1});
                }
                if (cur[1] - 1 >= 0 && grid[cur[0]][cur[1] - 1] == 1) {
                    grid[cur[0]][cur[1] - 1] = 2;
                    queue.add(new int[]{cur[0], cur[1] - 1});
                }
            }
            count++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return flag ? 0 : count - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
