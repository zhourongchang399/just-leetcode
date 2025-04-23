//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 618 👎 0


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
 * @description: 利用迭代实现中序遍历，记录二叉树的升序数组，同时计算数组后两位的绝对差，并更新最小绝对差，直到二叉搜索树遍历完成。
 * @date: 2025/4/23 21:57
 * @param null
 * @return
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int minAbs = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            if (root != null && root.left != null) {
                queue.add(root.left);
                root = root.left;
            } else {
                TreeNode node = queue.removeLast();
                list.add(node.val);
                if (list.size() >= 2) {
                    minAbs = Math.min(minAbs, Math.abs(list.get(list.size() - 1) - list.get(list.size() - 2)));
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                root = node.right;
            }
        }
        return minAbs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
