//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2904 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 暴力解法
 * @date: 2025/4/7 14:19
 * @param null
 * @return
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int r = i + 1;
            int l = i - 1;
            while (l >= 0 && heights[l] >= h) {
                l--;
            }
            while (r < heights.length && heights[r] >= h) {
                r++;
            }
            res = Math.max(res, h * (r - (l + 1)));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
