//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3079 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 回溯，找出当前路径所有答案，没有则回溯上一步，再继续搜索。
 * @date: 2025/4/1 13:20
 * @param null
 * @return
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<>();
        myPermute(nums, used, res, currentList);
        return res;
    }

    public void myPermute(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> currentList) {
        if (currentList.size() == nums.length){
            res.add(new ArrayList<>(currentList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            currentList.add(nums[i]);
            myPermute(nums, used, res, currentList);
            currentList.remove(currentList.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
