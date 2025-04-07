//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2703 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 采用自上而下法建大根堆，即对每一个根节点执行下滤操作，当左右子树都满足堆序性对根结点执行下滤，可以使得当前树都满足根序性；
 *               再将堆顶元素弹出（与堆末尾元素交换），只需对新的堆顶元素执行下滤操作即可得到新的大根堆，循环 k 次，即可得到第 k 位最大元素。
 * @date: 2025/4/7 20:59
 * @param null
 * @return
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 建堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            myFindKthLargest(nums, i, len);
        }
        // 弹出堆顶元素，并执行根结点下滤
        while (k-- > 0) {
            if (k == 0) return nums[0];
            int temp = nums[0];
            nums[0] = nums[len - 1];
            nums[len - 1] = temp;
            len--;
            myFindKthLargest(nums, 0, len);
        }
        return nums[0];
    }

    private void myFindKthLargest(int[] nums, int i, int len) {
        if (2 * i + 1 >= len) {
            return;
        }
        int maxIndex = 2 * i + 1;
        if (2 * i + 2 < len) {
            maxIndex = nums[2 * i + 1] > nums[2 * i + 2] ? 2 * i + 1 : 2 * i + 2;
        }
        if (nums[maxIndex] > nums[i]) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[i];
            nums[i] = temp;
            myFindKthLargest(nums, maxIndex, len);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
