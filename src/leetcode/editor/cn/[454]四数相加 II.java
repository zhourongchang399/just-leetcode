//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// Related Topics 数组 哈希表 👍 1102 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 用了两个哈希表分别存储 1，2 和 3，4 数组的和为 key，出现次数为 value，然后遍历一个哈希表搜索另一个哈希表是否存在当前 key 的负数，有则 count += value1 * value2.
 * @date: 2025/4/19 17:38
 * @param null
 * @return
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map1.put(nums1[i] + nums2[j], map1.getOrDefault(nums1[i] + nums2[j], 0) + 1);
                map2.put(nums3[i] + nums4[j], map2.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(-entry.getKey())) {
                count += entry.getValue() * map2.get(-entry.getKey());
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
