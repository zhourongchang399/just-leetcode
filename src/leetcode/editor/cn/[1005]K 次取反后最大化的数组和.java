//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 
//
// 
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
// 
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
//
// 以这种方式修改数组后，返回数组 可能的最大和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -100 <= nums[i] <= 100 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 贪心 数组 排序 👍 489 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 排序数组，将前 n < k 位的负值改为正值，并累加，最后判断余下 k 的次数是奇数还是偶数，偶数则不变，奇数则减去记录的最小值的倍数。
 * @date: 2025/5/9 16:36
 * @param null
 * @return
 */
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            min = Math.min(min, nums[i]);
            res += nums[i];
        }
        if(k % 2 == 1) {
            res -= 2 * min;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
