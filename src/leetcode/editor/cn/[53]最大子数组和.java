//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6950 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 数组中的任意子串和都可用当前位置前缀和减去前面任意位置前缀和得到，即 currentPreSum - preIndexPreSum 达到最大值
 *               即为最大子数组和，所以只需要遍历数组求得当前位置前缀和减去前面最小前缀和即为可能的答案，即维护最小前缀和，更新最大值即可；
 * @date: 2025/3/10 13:42
 * @param null
 * @return
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int minPreSum = 0;
        int maxValue = Integer.MIN_VALUE;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            maxValue = Math.max(preSum - minPreSum, maxValue);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return maxValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
