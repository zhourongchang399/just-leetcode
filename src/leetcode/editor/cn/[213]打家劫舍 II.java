//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1700 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 和打家劫舍类似，只是当选了第一个就不能选最后一个，求 [0，num.length - 2] 的最大值，选倒数第二个，不违法规则，不选倒数第二个选了倒数第三，也不能选倒数第一个，所以这就是最大值；
 *               选了第二个就不能选第一个，求 [1, num.length - 1] 的最大值，即使选了最后一个也不违法规则，如果不选最后一个，选了倒数第二个，也不能选第一个。所以这就是最大值。
 *               最后的最大值就是dp0[0],dp0[1],dp1[1],dp1[2] 中的最大值。
 * @date: 2025/5/23 22:15
 * @param null
 * @return 
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp0 = new int[nums.length];
        int[] dp1 = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1) {
                dp0[i] = nums[i] + Math.max(i + 2 < nums.length ? dp0[i + 2] : 0, i + 3 < nums.length ? dp0[i + 3] : 0);
            }
            if (i > 0) {
                dp1[i] = nums[i] + Math.max(i + 2 < nums.length ? dp1[i + 2] : 0, i + 3 < nums.length ? dp1[i + 3] : 0);
            }
        }
        return Math.max(Math.max(dp0[0],dp0[1]), Math.max(dp1[1],dp1[2]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
