//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2666 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 首先想到暴力破解法，即查到到所有子串的和和目标值一一匹对，得到最终结果，嵌套两个 for 循环即可，但是时间复杂度为 O(n^2);
 *               问题出在嵌套 for 循环，可以知道当前位置开头的子串和即等于第一个位置所有的子串和减去前一位置的所有子串和，所以可以在 for 循环中，
 *               只通过 pre[i] - pre[j] 即可，但是时间复杂度依旧为 O(n^2)；继续观察，可以知道所有的子串都可以用后一子串减去前一子串得到，所以
 *               target = pre[j] - pre[i],其中 j > i,即pre[j] - target = pre[i], 我们只需查找最新的子串和减去 target 是否存在，存在多少个，
 *               即可知道从最新位置到0位置究竟有多少前缀和满足条件，满足条件，即可以说是pre[j] - pre[i] 组成的子串就是我们需要的子串和；
 * @date: 2025/3/8 18:59
 * @param null
 * @return
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int pre_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            pre_sum += nums[i];

            if (map.containsKey(pre_sum - k)) {
                result += map.get(pre_sum - k);
            }

            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
