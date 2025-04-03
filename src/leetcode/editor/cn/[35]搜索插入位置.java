//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2484 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 递归实现二分查找法，取中值判断 target 是否相等，相等返回，不等继续递归下一层，左或右，直到找到或者找不到时,即，right < left 时，返回 left（左 left = mid，右 left = mid + 1）。
 * @date: 2025/4/3 22:54
 * @param null
 * @return
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        return myBinarySearch(0, nums.length - 1, nums, target);
    }

    private int myBinarySearch(int left, int right, int[] nums, int target) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (right < left) {
            return left;
        }
        if (target < nums[mid]) {
            return myBinarySearch(left, mid - 1, nums, target);
        } else {
            return myBinarySearch(mid + 1, right, nums, target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
