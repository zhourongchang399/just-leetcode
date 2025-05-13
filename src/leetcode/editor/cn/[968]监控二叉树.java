//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 782 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * @author: Zc
 * @description: 每一个结点都可以分为 1.有摄像头；2.有监控覆盖；3.无所谓有无监控覆盖（但是左右子树一定有监控覆盖）；
 *               当前结点的状态 1，可以由左右子节点的状态 3：无所谓有无监控覆盖 + 1 所表示；
 *               当前结点的状态 2，可以由状态 1 和 左结点有摄像头，右结点有监控覆盖 和 右结点有摄像头，左节点有监控覆盖，三者的最小值表示；
 *               当前结点的状态 3，可以由状态 1 和 左节点有监控覆盖 + 右结点有监控覆盖，两者的最小值所表示；
 *               通过递归，先计算底层结点的三个状态，逐步推导出上一层结点的三个状态，直到根节点。
 *               值得注意的是，空结点的三个状态，为（足够大的值，0，0），分别表示，空结点不可能有摄像头，不需要摄像头，即可满足有监控覆盖或无所谓有无监控覆盖这两个状态。
 * @date: 2025/5/13 23:41
 * @param null
 * @return
 */
class Solution {
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return res[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        int[] res = new int[3];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = left[2] + right[2] + 1;
        res[1] = Math.min(res[0], Math.min(left[0] + right[1], right[0] + left[1]));
        res[2] = Math.min(res[0], left[1] + right[1]);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
