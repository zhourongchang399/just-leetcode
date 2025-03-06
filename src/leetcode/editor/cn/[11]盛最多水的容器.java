//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 5344 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 水桶存多少水取决于最短的木板，所以容量问题就可写为 Min(left,right) * width;
 *               继续简化问题，一个数组组成的木板高度能容纳水最多的两个根木板，其实就是 width 和 Min(left,right) 都达到相对最大即可；
 *               即从数组两边开始遍历可以更快找到，相对最大 width，左右指针指向的木板即可计算当前容器容量，并维护最大值，因为 width 会随着
 *               指针移动变小，所以只有提高 height 才有可能比当前容器大，即移动左右指针中指向值最小的指针，直到相遇为止，即可得到最终答案；
 * @date: 2025/3/6 14:42
 * @param null
 * @return 
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
