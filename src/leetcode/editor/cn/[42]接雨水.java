//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5553 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 当前能接多少水，取决于左右柱子高度，即 min(left,right) - target
 *               同时，只要有一边比另一边一样高或更高，则当前位置装水容量可以确定，即 min(leftMax,rightMax) - target
 *               问题就可简化为，寻找当前位置的左边最高高度和右边最高高度，可以采用两个数组维护前缀和后缀高度，时间空间复杂度都为 O(n)
 *               继续简化，利用双指针遍历数组，假设初始高度都为0，指针移动更新高度，只会出现三种情况，左右高度相等，左高右低，左低右高
 *               当前位置的左右高度必有一边是确定的，只要另一边高或相等就可以计算当前位置容量，计算位置后移动该位置指针并更新高度，即可实现空间复杂度 O(1)
 * @date: 2025/3/6 14:33
 * @param null
 * @return
 */
class Solution {
    public int trap(int[] height) {
        int total = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                total += leftMax - height[left];
                left++;
            } else {
                total += rightMax - height[right];
                right--;
            }
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
