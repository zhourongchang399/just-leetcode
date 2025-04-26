//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
//
// Related Topics 位运算 数组 回溯 👍 1304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 递归回溯搜索所有子集，为了去重需要先排序后，当前位置搜索完毕后，都需跳过当前值相同的后续值。
 * @date: 2025/4/26 12:42
 * @param null
 * @return
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        mySubsetsWithDup(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void mySubsetsWithDup(int[] nums, int index, ArrayList<Integer> path, List<List<Integer>> res) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            mySubsetsWithDup(nums, i + 1, path, res);
            path.remove(path.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
