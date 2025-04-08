//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2803 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 维护一个目前最大可达边界，当遍遍历到目前最大可达边界则 step++，并将目前最大可达边界更新为该边界内可跳跃到下一最大可达边界的位置，遍历到数组末尾即可。
 * @date: 2025/4/8 15:08
 * @param null
 * @return
 */
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] >= nums.length - 1) return 1;
        int step = 0;
        int len = nums[0];
        int lastLen = len;
        for (int i = 0; i <= len; i++) {
            if (len <= i + nums[i]) {
                len = Math.min(i + nums[i], nums.length - 1);
            }
            if (i == lastLen) {
                lastLen = len;
                step++;
            }
        }
        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
