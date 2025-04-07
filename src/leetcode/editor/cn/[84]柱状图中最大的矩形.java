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
 * @description: 寻找柱状图中最大的矩形，即寻找当前柱子的左右边界长度并乘当前柱子高度；通过遍历左右边界时间复杂度太高，但是通过观察可知道当左边柱子高度小于当前柱子高度，则他的最左边界最多到这个柱子，同理右边一样；
 *               当左边柱子大于当前柱子高度则左边边界可能还能左扩直到遇到小于当前柱子高度的柱子，根据这个结论，我们可以通过单调递增栈记录左边柱子的高度，当当前柱子大于栈顶元素则左边界确定；
 *               当当前柱子小于栈顶元素则出栈直到当前柱子大于栈顶元素，即可确定当前柱子的左边界，同理右边界。
 *               结论可归纳为：
 *               （1）当需要寻找当前位置左边第一个小于其值的位置时：从左到右遍历维护单调递增栈；
 *               （2）当需要寻找当前位置右边第一个小于其值的位置时：从右到左遍历维护单调递增栈；
 *               （3）当需要寻找当前位置左边第一个大于其值的位置时：从左到右遍历维护单调递减栈；
 *               （4）当需要寻找当前位置右边第一个大于其值的位置时：从右到左遍历维护单调递减栈。
 * @date: 2025/4/7 14:19
 * @param null
 * @return
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = Integer.MIN_VALUE;

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(-1);
        int[] leftRange = new int[heights.length];
        int[] rightRange = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftRange[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.add(heights.length);
        for (int i = heights.length - 1; i >= 0; i--) {
            while (stack.peek() != heights.length && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightRange[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (rightRange[i] - leftRange[i] - 1));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
