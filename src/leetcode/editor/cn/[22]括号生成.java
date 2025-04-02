//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3812 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 递归添加左括号和右括号，并记录左右括号的数量，当左右括号均等于 n 时保存当前路径，当左括号小于右括号裁剪当前路径。
 * @date: 2025/4/2 23:16
 * @param null
 * @return
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        int left = 0, right = 0;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        myGenerateParenthesis(left, right, sb, res, n);
        return res;
    }

    private void myGenerateParenthesis(int left, int right, StringBuilder sb, List<String> res, int n) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            sb.append('(');
            myGenerateParenthesis(left + 1, right, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < n) {
            sb.append(')');
            myGenerateParenthesis(left, right + 1, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
