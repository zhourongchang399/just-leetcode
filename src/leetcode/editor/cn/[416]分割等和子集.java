//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2331 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 0/1背包问题，即要还是不要当前位置的值，采用 dfs 算法遍历所有可能即可，但是复杂度高；
 *               因为是否选择当前位置的值能否满足条件，假如不选即与前一位置是否满足条件有关，假如选也与前一位置 target - nums[currentIndex] 有关；
 *               考虑采用动态规划，即 dp[i][target] = dp[i - 1][target] || dp[i - 1][target - nums[i]], return dp[n][target]。
 * @date: 2025/4/12 15:23
 * @param null
 * @return
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 != 0) return false;
        if (max > sum / 2) return false;

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == target) return true;
            }
        }

        return false;

//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if (sum % 2 != 0) return false;
//        int[][] dp = new int[nums.length][(sum / 2) + 1];
//        if (nums[0] == sum / 2) {
//            return true;
//        }
//
//        for (int i = 0; i <= sum / 2; i++) {
//            dp[0][i] = nums[0] <= i ? nums[0] : 0;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 1; j <= sum / 2; j++) {
//                if (nums[i] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
//                }
//                if (dp[i][j] == sum / 2) {
//                    return true;
//                }
//            }
//        }
//
//        return false;

//        if (nums.length == 1) return false;
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            max = Math.max(max, nums[i]);
//        }
//        int target = sum / 2;
//        if (sum % 2 != 0) return false;
//        if (max > target) return false;
//
//        boolean[] dp = new boolean[target + 1];
//        dp[0] = true;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = target; j >= nums[i]; j--) {
//                dp[j] = dp[j] || dp[j - nums[i]];
//            }
//        }
//
//        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
