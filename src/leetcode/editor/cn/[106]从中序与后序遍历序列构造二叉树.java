//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1332 👎 0


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
 * @description: 利用后序遍历数组确定根节点，再利用当前根节点划分左右中序与后序数组，最后递归确定左右子树即可。
 * @date: 2025/4/23 17:37
 * @param null
 * @return
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return myBuildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode myBuildTree(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (postorderStart > postorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int index = inorderStart;
        for (; index < inorderEnd; index++) {
            if (inorder[index] == postorder[postorderEnd]) {
                break;
            }
        }
        root.left = myBuildTree(inorder, postorder, inorderStart, index - 1, postorderStart, postorderStart + index - inorderStart - 1);
        root.right = myBuildTree(inorder, postorder, index + 1, inorderEnd, postorderStart + index - inorderStart, postorderEnd - 1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
