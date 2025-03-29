//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 2118 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 构建图并深度遍历即可，当遍历图存在环时返回 False，即递归还未回溯到当前节点就已经走回到了该节点；
 *               注意不需要构建完全邻接矩阵，只需要记录每个节点的邻域节点即可。
 * @date: 2025/3/29 14:52
 * @param null
 * @return
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        short[] visited = new short[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visite(numCourses, visited, i, adj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean visite(int numCourses, short[] visited, int i, ArrayList<ArrayList<Integer>> adj) {
        if (visited[i] == 0) {
            visited[i] = 1;
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (!visite(numCourses, visited, adj.get(i).get(j), adj)) {
                    return false;
                }
            }
            visited[i] = 2;
        } else if (visited[i] == 1) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
