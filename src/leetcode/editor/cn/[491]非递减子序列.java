//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 856 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 递归实现回溯，因为是非递减子序列，所以当前值小于前一值时需要跳过，同时对于子序列无法采用先排序后跳过同一值的方式去重；
 *               所以采用哈希表记录当前子递归下已经遍历过的值，set 中存在则跳过，否则执行。
 * @date: 2025/4/26 16:02
 * @param null
 * @return
 */
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        myFindSubsequences(nums, Integer.MIN_VALUE, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void myFindSubsequences(int[] nums, int pre, int index, ArrayList<Integer> path, List<List<Integer>> res) {
        if (index == nums.length) {
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = index; i < nums.length; i++) {
            if (pre > nums[i] || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            if (path.size() >= 2) {
                res.add(new ArrayList<>(path));
            }
            myFindSubsequences(nums, nums[i], i + 1, path, res);
            path.remove(path.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
