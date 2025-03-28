//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2029 👎 0


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
 * @description: 通过前序遍历二叉树的同时，使用哈希表存储前序和出现的次数，计算当前节点为尾节点的链表有多少符合条件的路径；
 *               再通过回朔剔除哈希表中当前节点的前缀和次数，递归回溯即可。
 * @date: 2025/3/28 15:31
 * @param null
 * @return 
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Map<Double, Integer> map = new HashMap<>();
        map.put(0.0, 1);
        double prefixSum = 0;
        TreeNode res = new TreeNode(0);
        inorder(root, map, prefixSum, targetSum, res);
        return res.val;
    }

    private void inorder(TreeNode root, Map<Double, Integer> map, double prefixSum, int targetSum, TreeNode res) {
        if(root == null) return;
        prefixSum += root.val;
        if (map.containsKey(prefixSum - targetSum)) {
            res.val += map.get(prefixSum - targetSum);
        }
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        inorder(root.left, map, prefixSum, targetSum, res);
        inorder(root.right, map, prefixSum, targetSum, res);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
