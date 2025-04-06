//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7477 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 要达到 log(m + n) 就不能归并数组后二分查找，只能采用二分查找法，算法目标是寻找到奇数组的第 k 小的数为中位数，偶数组是寻找第 k 小和 第 k + 1小的平均数为中位数；
 *               要在不归并数组的前提下二分查找，可以维护两个指针依次遍历两个数组直到第 k 和 第 k + 1 小，但是时间复杂度为 （m+n）/2, 所以可以利用数组已经排序的特性，按批次遍历；
 *               即每次排除 k / 2 数量的数，下一次则是 (k - (k / 2) / 2 的数，直到 k 为 1 即寻找到了第 k 位，采用递归实现即可，奇数只需一次，偶数则是两次最后求平均。
 * @date: 2025/4/6 13:29
 * @param null
 * @return
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (myFindMedianSortedArrays(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2) + myFindMedianSortedArrays(nums1, nums2, 0, 0, ((nums1.length + nums2.length) / 2) + 1)) / 2.0;
        } else {
            return myFindMedianSortedArrays(nums1, nums2, 0, 0, ((nums1.length + nums2.length) / 2) + 1);
        }
    }

    private int myFindMedianSortedArrays(int[] nums1, int[] nums2, int n, int m, int mid) {
        if (mid == 1) {
            if (n >= nums1.length) {
                return nums2[m];
            }
            if (m >= nums2.length) {
                return nums1[n];
            }
            return Math.min(nums1[n], nums2[m]);
        }
        if (n >= nums1.length) {
            return nums2[m + mid - 1];
        }
        if (m >= nums2.length) {
            return nums1[n + mid - 1];
        }
        int k = mid / 2;
        if (n + k > nums1.length) {
            k = nums1.length - n;
        } else if (m + k > nums2.length) {
            k = nums2.length - m;
        }
        if (nums1[n + k - 1] > nums2[m + k - 1]) {
            m = m + k;
        } else {
            n = n + k;
        }
        mid = mid - k;
        return myFindMedianSortedArrays(nums1, nums2, n, m, mid);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
