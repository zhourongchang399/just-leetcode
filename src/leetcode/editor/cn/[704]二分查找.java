//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics 数组 二分查找 👍 1738 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 二分查找，判断 mid 位置上的值是否为 target，是则返回，不是则判断是否大于 target，是则查找 [left, mid - 1] 是否存在 target，不是则查找 [mid + 1, right] 是否存在 target。
 * @date: 2025/4/14 12:59
 * @param null
 * @return
 */
class Solution {
    public int search(int[] nums, int target) {
        return myBinarySearch(nums, 0, nums.length - 1, target);
    }

    public int myBinarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return myBinarySearch(nums, mid + 1, right, target);
        } else {
            return myBinarySearch(nums, left, mid - 1, target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
