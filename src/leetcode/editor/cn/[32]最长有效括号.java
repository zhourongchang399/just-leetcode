//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2679 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 利用栈将符合条件的位置的值置为 dp[i] = 2 + dp[i - 1] + dp[stack.pop() - 1 >= 0]。
 * @date: 2025/4/12 15:53
 * @param null
 * @return
 */
class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(stack.peek()) == '(') {
                dp[i] = 2;
                dp[i] += dp[i - 1];
                int leftIndex = stack.pop();
                if (leftIndex > 0) {
                    dp[i] += dp[leftIndex - 1];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
