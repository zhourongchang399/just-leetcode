//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2505 👎 0


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
 * @description: 递归分治，preOrder 的第一位即为当前根节点，再根据当前根节点划分 inOrder，和preOrder；
 *               将当前节点左右子树的构造递归为新划分的 preOrder 和 inOrder，递归到最后节点则直接返回即可。
 * @date: 2025/3/28 14:38
 * @param null
 * @return
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;

        int rootIndex = 0;
        while (rootIndex < inorder.length) {
            if(inorder[rootIndex] == preorder[0]) {
                break;
            }
            rootIndex++;
        }

        int[] leftInList = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInList = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] leftPreList = Arrays.copyOfRange(preorder, 1, 1 + leftInList.length);
        int[] rightPreList = Arrays.copyOfRange(preorder, leftInList.length + 1, preorder.length);
        root.left = buildTree(leftPreList, leftInList);
        root.right = buildTree(rightPreList, rightInList);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
