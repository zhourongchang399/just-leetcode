//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2576 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 要想将零元素移动到末尾，同时不打乱非零元素相对顺序，即不考虑零的顺序，只保证非零元素顺序即可；
 *               要想保证非零元素顺序，只需要0开始遍历，将当前位置或以后遇到的第一个非零元素替换过来即可，同时也能保证零元素被替换到数组末尾；
 *               要想实现该功能，通过快慢指针，慢指针指向当前顺序需要填充的非零元素位置，快指针则从当前位置或上次非零元素位置一直移动到它遇到的下一个非零元素，完成替换即可；
 * @date: 2025/3/6 14:42
 * @param null
 * @return
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;  // 用于标记非零元素的位置

        // 通过一次遍历，把所有非零元素移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交换当前元素和 nonZeroIndex 指向的位置
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;

                // 移动 nonZeroIndex
                nonZeroIndex++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
