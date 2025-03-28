//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2376 👎 0


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
 * @description: 与最大连续子串和思路一样，记录前缀最大和再与当前位置的值相加和单独比较，更新前缀子串和并更新最大子串和，遍历到末尾即可；
 *               同理二叉树中，通过递归找出当前节点的左右子树的最大前缀和，并比较即可，回溯即为数组的遍历。
 * @date: 2025/3/28 22:46
 * @param null
 * @return
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        TreeNode res = new TreeNode(Integer.MIN_VALUE);
        myMaxPathSum(root, res);
        return res.val;
    }

    public int myMaxPathSum(TreeNode root, TreeNode res) {
        if (root == null) return 0;
        int left = myMaxPathSum(root.left, res);
        int right = myMaxPathSum(root.right, res);
        int prefixMaxSum = Math.max(root.val, root.val + Math.max(left, right));
        res.val = Math.max(res.val, Math.max(prefixMaxSum, root.val + left + right));
        return prefixMaxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
