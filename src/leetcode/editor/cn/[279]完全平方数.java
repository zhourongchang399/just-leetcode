//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 2160 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 动态规划，targetValue 求开方后得到的 k 即为其可减去的最大完全平方数，不断搜索 k,...,k-i,...1 的平方与其做差即可得到答案；
 *               同时为了不重复计算，先计算 1,2,...,targetValue - 1 的最少完全平方数，这样就可以在计算 targetValue - i 时马上得到对应的最少完全平方数；
 *               即 minCount[targetValue] = minCount[targetValue - k * k] + 1,其中 k 为 k,...,k-i,...1。
 * @date: 2025/4/9 12:28
 * @param null
 * @return
 */
class Solution {
    public int numSquares(int n) {
        int[] minCount = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int k = (int) Math.sqrt(i);
            minCount[i] = Integer.MAX_VALUE;
            for(int j = k; j >= 1; j--) {
                int m = i - j * j;
                minCount[i] = Math.min(minCount[i], minCount[m] + 1);
            }
        }
        return minCount[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
