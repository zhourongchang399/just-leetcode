//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 3159 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 二分查找选择排序数组，只需要判断当前数组是否符合排序要求，符合则二分查找，不符合则二分数组，左右再判断数组是否符合排序要求，每一次总会有一边符合要求，一边不符合，直到最后单独切分则都符合，回溯即可得到最后答案。
 * @date: 2025/4/4 23:43
 * @param null
 * @return
 */
class Solution {
    public int search(int[] nums, int target) {
        return myBinarySearch(nums, 0, nums.length - 1, target);
    }

    public int myBinarySearch(int[] nums, int left, int right, int target) {
        if (nums[right] >= nums[left]) {
            while (true) {
                int mid = (left + right) / 2;
                if (left > right) {
                    return -1;
                }
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        } else {
            int mid = (left + right) / 2;
            int leftValue = myBinarySearch(nums, left, mid, target);
            int rightValue = myBinarySearch(nums, mid + 1, right, target);
            return leftValue != -1 ? leftValue : rightValue;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
