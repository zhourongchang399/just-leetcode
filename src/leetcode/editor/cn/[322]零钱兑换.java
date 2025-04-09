//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 3029 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 零钱兑换，与完全平方数类似的解法，只需要计算出当前位置的前 n 位的 minCountList，即可通过 minCountList[targetValue - coins[i]] + 1 求得是否满足条件。
 * @date: 2025/4/9 12:33
 * @param null
 * @return
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCountList = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            minCountList[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int k = i - coins[j];
                if (k >= 0 && minCountList[k] != -1) {
                    minCountList[i] = Math.min(minCountList[i], minCountList[k]);
                }
            }
            minCountList[i] = minCountList[i] == Integer.MAX_VALUE ? -1 : minCountList[i] + 1;
        }

        return minCountList[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
