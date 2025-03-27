//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 2109 👎 0


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
 * @description: 1.递归分治，将二叉树的曾想遍历问题分解为一个个子问题，只需要求出左右子树的层序数组，再拼接二者即可得到当前节点的层序数组；
 *               2.队列，将每一层的节点入队，节点出队时将其左右节点入队，每次记录每一层的数目，出队对应次数即存储为一层数组；
 * @date: 2025/3/27 13:31
 * @param null
 * @return
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(root == null) return new ArrayList<>();
//        List<List<Integer>> leftList = levelOrder(root.left);
//        List<List<Integer>> rightList = levelOrder(root.right);
//        for (int i = 0; i < rightList.size(); i++) {
//            if (i < leftList.size()) {
//                leftList.get(i).addAll(rightList.get(i));
//            } else {
//                leftList.add(i, rightList.get(i));
//            }
//        }
//        List<Integer> current = new ArrayList<>();
//        current.add(root.val);
//        leftList.add(0, current);
//        return leftList;

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                currentList.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(currentList);
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
