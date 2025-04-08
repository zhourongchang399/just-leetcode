//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 3037 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 回溯法，搜索全部可达路径并通过剪枝（当前位置不行则置为零）减少重复路径，复杂度 O（n^2）。
 * @date: 2025/4/8 13:57
 * @param null
 * @return
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return true;
        return myCanJump(nums, 0);
    }

    private boolean myCanJump(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        } else if (nums[index] == 0) {
            return false;
        }

        for (int i = nums[index]; i > 0; i--) {
            if (myCanJump(nums, index + i)) {
                return true;
            }
        }
        nums[index] = 0;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
