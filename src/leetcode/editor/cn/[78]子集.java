//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2463 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 回溯，搜索每一条路径上的所有可能，即当前位置和后面位置的值组合，当已经组合过就跳过，继续和后面位置的值组合，直到回到开始位置。
 * @date: 2025/4/2 13:22
 * @param null
 * @return
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            mySubsets(i, list, nums, res);
        }
        return res;
    }

    private void mySubsets(int index, List<Integer> list, int[] nums, List<List<Integer>> res) {
        if (index == nums.length) {
            return;
        }
        list.add(nums[index]);
        res.add(new ArrayList<>(list));
        for (int i = index + 1; i < nums.length; i++) {
            mySubsets(i, list, nums, res);
        }
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
