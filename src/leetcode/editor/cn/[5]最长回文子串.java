//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7646 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 暴力破解法
 * @date: 2025/4/12 17:01
 * @param null
 * @return
 */
class Solution {
    public String longestPalindrome(String s) {
        for (int i = s.length(); i >= 1; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (myPalindrome(s, j, j + i - 1)) {
                    return s.substring(j, j + i);
                }
            }
        }
        return s.substring(0, 1);
    }

    public boolean myPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
