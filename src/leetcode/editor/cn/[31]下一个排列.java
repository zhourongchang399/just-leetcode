//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 2674 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 下一个排列即从尾到头找到一个相对较小的数，同时在该位置到末尾中从头到尾再找一个比相对较小的数大一点的数为较大数，二者互换，并对新的较大数后的序列升序排列；
 *               较小数的意思是，找到第一个比末尾某一个连续数小的数，这样代表其可以与他的连续数互换以达到要求，同时为了较大数能够尽可能小，所以需要确认是否还有一个较大数是与较小数最切近的。
 * @date: 2025/4/13 23:00
 * @param null
 * @return
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] < nums[i + 1]) {
                minIndex = i;
                break;
            }
        }
        if (minIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length - 1; i >= minIndex + 1; i--) {
            if (nums[i] > nums[minIndex]) {
                maxIndex = i;
                break;
            }
        }
        int temp = nums[maxIndex];
        nums[maxIndex] = nums[minIndex];
        nums[minIndex] = temp;
        Arrays.sort(nums, minIndex + 1, nums.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
