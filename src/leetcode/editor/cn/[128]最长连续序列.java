//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,0,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2405 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 在无序数组中寻找最长连续序列，第一步应该先去重，防止重复值干扰计算，第二步则是排序，即可遍历数组维护最大值，寻找到最长序列；
 *               但是对数组去重和排序是一件非常耗费资源的事情，所以想到用哈希表的特性去解决该问题，所以首先遍历数组，值存入 HashSet中；
 *               完成了去重操作后，继续利用哈希表查找快的优势，只需要遍历一次数组，查询 currentValue 是否是序列第一位，即是否存在上一位；
 *               确定了 currentValue 是首位后，循环查找下一位并维护最大值，即可得到答案，时间复杂度为 O(nLog(n));
 * @date: 2025/3/6 15:05
 * @param null
 * @return 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        // 去重
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        // 初始化结果
        int maxLength = 0;

        for (int num : set) {
            // 从连续序列首位开始计算
            if (!set.contains(num - 1)) {
                int currentLength = 1;

                // 包含下一位连续数字
                while (set.contains(++num)) {
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
