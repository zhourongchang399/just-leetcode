//给定一个二叉树，判断它是否是 平衡二叉树 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1597 👎 0


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
 * @description: 利用后序遍历搜索高度的方法，汇总判断更新flag，并返回当前高度；
 *               递归，一直到树的叶子节点判断是否该节点为根节点是否为平衡二叉树，不是则更新 flag，同时返回该节点高度，递归汇总最后到该树根节点，判断是否为二叉树。
 * @date: 2025/4/23 15:35
 * @param null
 * @return
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        TreeNode res = new TreeNode();
        treeDepth(root, res);
        return res.val == 0;
    }

    private int treeDepth(TreeNode root, TreeNode res) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left, res);
        int rightDepth = treeDepth(root.right, res);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            res.val = -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
