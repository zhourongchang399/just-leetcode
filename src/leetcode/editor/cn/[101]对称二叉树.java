//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2920 👎 0


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
 * @description: 递归分治，将对称问题拆分为一个个子问题，当前节点的左子树的值和右子树的值比较，左子树的左子树和右子树的右子树比较，左子树的右子树和右子树的左子树比较，即为一个拆分问题，最后递归返回每一个问题的结果。
 * @date: 2025/3/25 19:32
 * @param null
 * @return
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) return false;
        if (left == null && right == null) return true;
        return symmetric(left.left, right.right) && symmetric(left.right, right.left) && left.val == right.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
