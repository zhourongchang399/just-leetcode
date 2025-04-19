//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 7330 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 三数之和问题可以简化为两数之和问题，但是如果使用哈希表，则会导致多个重复解的去重工作非常耗时，同时还需维护一个哈希表；
 *               所以，可以利用头尾双指针，遍历有序数组求两数之和，同时只需跳过前后值一致的位置，即可保证不出现重复解；
 *               即先排序数组，再遍历数组，三元组的组成只能是 [-,0,+],[-,-,+],[-,+,+] 三种可能，所以遍历数组即是确定左边界，搜索中间和右边界的和等于左边界即可，
 *               当前位置的头指针为 currentIndex + 1，尾指针指向末尾，两数之和大于 currentValue，则左移尾指针，否则右移头指针，相等则存入列表中，
 *               并跳过所有重复值以规避重复结果，即可得到当前值的两数之和所有唯一可能，因为左边界是确定的，以某一个确定的值开始，搜索他的所有可能。
 * @date: 2025/3/6 15:05
 * @param null
 * @return 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序
        Arrays.sort(nums);

        int targetIndex = 0;

        while (targetIndex < nums.length - 2) {
            if (nums[targetIndex] > 0) break;
            // 移动targetIndex直到非重复值
            if (targetIndex > 0 && nums[targetIndex] == nums[targetIndex - 1]) {
                targetIndex++;
                continue;
            }

            // 目标值
            int target = nums[targetIndex];
            // 左右指针
            int left = targetIndex + 1;
            int right = nums.length - 1;

            // 两数之和等于-target
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -target) {
                    // 保存结果
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(target);
                    res.add(list);
                    // 移动左右指针直到指到非重复值
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (right > targetIndex + 1 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum < -target) {
                    // 两数之和小于-target，左指针右移
                    left++;
                } else{
                    // 两数之和大于-target，右指针左移
                    right--;
                }
            }

            // 移动targetIndex
            targetIndex++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
