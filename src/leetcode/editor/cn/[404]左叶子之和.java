//给定二叉树的根节点 root ，返回所有左叶子之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 769 👎 0


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
 * @description: 递归遍历二叉树，如果确定当前节点是左叶子节点则累加，否则继续。
 * @date: 2025/4/23 16:48
 * @param null
 * @return
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        TreeNode res = new TreeNode(0);
        mySumOfLeftLeaves(root, false, res);
        return res.val;
    }

    private void mySumOfLeftLeaves(TreeNode root, boolean flag, TreeNode res) {
        if (flag && root.left == null && root.right == null) {
            res.val += root.val;
            return;
        }
        if (root.left != null) {
            mySumOfLeftLeaves(root.left, true, res);
        }
        if (root.right != null) {
            mySumOfLeftLeaves(root.right, false, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
