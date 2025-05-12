//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 513 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 遍历数字，当前位置后续递减时，对前序数字 - 1 递归寻找最大的单调递归的数字，后续则补全 9 的 digits.size() - currentIndex - 1 次方。
 * @date: 2025/5/12 21:31
 * @param null
 * @return
 */
class Solution {
    public int monotoneIncreasingDigits(int n) {
        List<Integer> digits = new ArrayList<Integer>();
        while (n > 0) {
            int current = n % 10;
            n /= 10;
            digits.add(0, current);
        }

        int res = 0;
        int k = 0;
        for (int i = 0; i < digits.size(); i++) {
            res *= 10;
            if (i == digits.size() - 1) {
                res += digits.get(i);
                return res;
            }
            res += digits.get(i);
            if (digits.get(i) > digits.get(i + 1)) {
                res = monotoneIncreasingDigits(res - 1);
                res *= Math.pow(10, digits.size() - i - 1);
                k = i;
                break;
            }
        }

        for (int i = 0; i < digits.size() - k - 1; i++) {
            res += 9 * Math.pow(10, i);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
