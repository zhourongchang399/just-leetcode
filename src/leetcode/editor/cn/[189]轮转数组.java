//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// Related Topics 数组 数学 双指针 👍 2336 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 轮转数组，观察可得当 k >= nums.length 时，实际轮转为 k - nums.length，所以首先 k = k % nums.length,
 *               k == 0 则代表原地不动。再然后只需要移动 nums.length 下即可，遍历 nums 数组，当前位置值替换后 k 位的值，
 *               记录后 k 位的值，不断轮转，当轮转回初始位置，则初始位置移动一位，继续轮转，即可得到答案。
 * @date: 2025/3/11 13:48
 * @param null
 * @return
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int step = nums.length;
        int left = 0;
        int right = 0;
        int value = nums[right];
        while (step > 0) {
            if (right + k < nums.length) {
                right = right + k;
            } else {
                right = right + k - nums.length;
            }
            int temp = nums[right];
            nums[right] = value;
            value = temp;
            if (left == right) {
                left++;
                right++;
                value = nums[left];
            }
            step--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
