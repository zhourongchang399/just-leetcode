//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 2143 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 目标和等于选取一定数量的数组和 sum 减去剩余数组和 neg = total - sum，所以简化为一个01背包问题；
 *              sum - (total - sum) = target 背包容量为 sum = (target + total) / 2;
 *              同时01背包问题应该为当前数组，可以填充满背包的装法有多少种，dp[i][j] = nums[i] <= sum ? dp[i - 1][j] + dp[i - 1][sum - nums[i]] ? dp[i - 1][j];
 * @date: 2025/5/18 14:16
 * @param null
 * @return
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum + target) % 2 == 1) {
            return 0;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }

        int volumn = (sum + target) / 2;
        int[][] dp = new int[nums.length][volumn + 1];
        dp[0][0] = 1;
        if (nums[0] <= volumn) {
            dp[0][nums[0]] = 1;
        }

        int numZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) numZero++;
            dp[i][0] = (int) Math.pow(2.0, numZero);
        }

        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 0; j <= volumn; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][volumn];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
