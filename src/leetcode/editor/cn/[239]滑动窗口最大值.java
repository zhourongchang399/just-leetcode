//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 3043 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 首先想到暴力解法，只需要遍历数组，并找个 size = k 的窗口中的最大值，但是时间复杂度达到了 k * n;
 *               所以优化的地方在于如何快速找到窗口内的最大值，随着遍历，左边界需要抛弃，右边界需要纳入计算。同时，
 *               可以观察到倘若右边界新纳入的值比前面的值大，那么这些值在后续计算中将毫无作用，需要丢弃，所以可得，
 *               维护一个 Index 单调递减队列，有新值插入则应该将原有队列中小于该值的对象去掉，并去掉窗口外的对象，
 *               此队列中的对象都在窗口内，并且前后对象和 nums 中的相对顺序一致，并且队头是最大值；
 * @date: 2025/3/9 17:14
 * @param null
 * @return
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            // 弹出窗口外的 Index
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 弹出队列中小于当前位置的值的 Index
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // 插入队列
            deque.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
