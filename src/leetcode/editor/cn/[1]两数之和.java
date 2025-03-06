//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 19387 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 寻找两数之和等于目标值，直觉是两层遍历，枚举所有可能即可得到答案，但是时间复杂度是 O(n^2)，不采纳
 *               时间复杂度高主要问题在查询数据中，只有遍历数组才可得到结果，所以优化方向就是用哈希表替代数组，
 *               只需遍历一遍数组，每次都从哈希表从查询 targetValue - currentValue 是否存在，存在即可通过Key获取Value，
 *               即数组中的下标，即可得到答案，若不存在，则存入（currentValue，currentIndex）到哈希表中，最坏的结果也只是时间复杂度 O(n)
 *               类似于，现实生活中，打电话没人接听，但是记录拨通记录，待目标人物有空了（遍历到了）查看通话记录后回拨，即可得到回复（答案）
 * @date: 2025/3/6 14:42
 * @param null
 * @return 
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[] {i, map.get(remain)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
