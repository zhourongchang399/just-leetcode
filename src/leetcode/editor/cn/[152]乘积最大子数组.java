//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2414 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 假如只有数组中只有正数和零，则当前位置的乘积最大子数组就等于前一位置的最大乘积 * 当前位置和当前位置的最大值；
 *               但是数组中存在负数，则当前位置的乘积最大子数组就等于前一位置的最小乘积 * 当前位置和当前位置的最大值；
 *               所以需要两个数组分别记录前缀数组的最大和最小乘积，负数则是与最小乘积相乘，正数则是与最大乘积相乘。
 * @date: 2025/4/11 10:49
 * @param null
 * @return
 */
class Solution {
    public int maxProduct(int[] nums) {
        int[] minDP = new int[nums.length + 1];
        int[] maxDP = new int[nums.length + 1];
        minDP[0] = 1;
        maxDP[0] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                minDP[i + 1] = Math.min(nums[i], maxDP[i] * nums[i]);
                maxDP[i + 1] = Math.max(nums[i], minDP[i] * nums[i]);
            } else {
                minDP[i + 1] = Math.min(nums[i], minDP[i] * nums[i]);
                maxDP[i + 1] = Math.max(nums[i], maxDP[i] * nums[i]);
            }
            res = Math.max(res, maxDP[i + 1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
