//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 输入 保证 数组 answer[i] 在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 1976 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 除自身以外数组的乘积，当前位置的除自身以外数组的乘积为前缀积 * 后缀积，所以只需要遍历数组，计算前缀积和后缀积数组即可。
 * @date: 2025/3/11 14:35
 * @param null
 * @return
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixMutiple = new int[nums.length + 1];
        int[] suffixMutiple = new int[nums.length + 1];
        prefixMutiple[0] = 1;
        suffixMutiple[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixMutiple[i + 1] = prefixMutiple[i] * nums[i];
            suffixMutiple[i + 1] = suffixMutiple[i] * nums[nums.length - i - 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixMutiple[i] * suffixMutiple[nums.length - i - 1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
