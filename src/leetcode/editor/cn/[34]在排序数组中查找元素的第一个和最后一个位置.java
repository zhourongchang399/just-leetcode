//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2973 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 递归结合二分查找，找到 targetIndex 后，继续在 [left, mid - 1],[mid + 1, right] 两个范围中查找 target，直到找不到为止，返回 [-1, -1]；
 *               并且递归回到上一层，并更新 range 并继续返回，左边的只保留 range[0]，右边只保留 range[1]，直到回到第一层，既是答案。
 * @date: 2025/4/3 23:52
 * @param null
 * @return 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        return myBinarySearch(nums, target, left, right);
    }

    private static int[] myBinarySearch(int[] nums, int target, int left, int right) {
        while (true) {
            int mid = (left + right) / 2;
            if (left > right) {
                break;
            }
            if (nums[mid] == target) {
                int[] res = new int[]{mid, mid};
                int[] leftRange = myBinarySearch(nums, target, left, mid - 1);
                int[] rightRange = myBinarySearch(nums, target, mid + 1, right);
                if (leftRange[0] != -1) {
                    res[0] = leftRange[0];
                }
                if (rightRange[1] != -1) {
                    res[1] = rightRange[1];
                }
                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
