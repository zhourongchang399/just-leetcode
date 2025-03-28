//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2938 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * @author: Zc
 * @description: 二叉树的最近公共祖先，可以看作是遍历每一个节点是否是最近公共祖先，
 *               即分解问题，判断当前节点是否满足条件，倘若左右子树都找到了即代表当前节点就是最近公共祖先；
 *               倘若只有一边找到了，则代表找到的那个节点就是最近公共祖先，因为另一个节点只会出现在那个节点的后代，
 *               或者那个节点的父辈的后代中，所以通过递归分治，从根节点往叶子节点遍历，查找符合条件的节点，
 *               再通过回溯，（1）leftNode != null && rightNode != null return root，当前节点一定是最近公共祖先
 *               （2）return leftNode != null ? leftNode : rightNode; 当前节点肯能是最近公共祖先
 *               汇总到根节点，返回结果即为答案。
 * @date: 2025/3/28 16:49
 * @param null
 * @return
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode == null && rightNode == null) return null;
        return leftNode != null ? leftNode : rightNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
