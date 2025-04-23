//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 797 👎 0


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
 * @description: 利用迭代实现中序遍历，因为二叉搜索树的中序遍历为升序排列，所以可以记录当前值的 count，和 maxCount；
 *               当 count == maxCount 时，则添加当前值到 res 中，当 count > maxCount 时，则清空 res,更新 maxCount；
 *               并添加当前值到 res 中，直到中序遍历完二叉搜索树为止。
 * @date: 2025/4/23 22:27
 * @param null
 * @return
 */
class Solution {
    public int[] findMode(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        stack.add(root);
        int maxCount = 0;
        int count = 0;
        TreeNode pre = null;
        while(!stack.isEmpty()) {
            if (root != null && root.left != null) {
                stack.addLast(root.left);
                root = root.left;
            } else {
                TreeNode node = stack.removeLast();
                if (pre == null) {
                    count = 1;
                } else if (pre.val == node.val) {
                    count++;
                } else {
                    count = 1;
                }
                pre = node;
                if (count > maxCount) {
                    res.clear();
                    maxCount = count;
                    res.add(node.val);
                } else if (count == maxCount){
                    res.add(node.val);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
                root = node.right;
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
