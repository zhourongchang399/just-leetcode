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
 * @description: 中心拓展，如果当前位置 Si == Sj && P[i + 1, j - 1] is Palindrome 则 P[i, j] is Palindrome;
 *               所以只需遍历字符串，分别对中心回文子串两边拓展直到不符合条件为止，并维护 startIndex 和 maxLength 即可；
 *               但仍需考虑类似 abba 的情况，abba 是当前最长回文子串，但是无法通过当个位置开始向外扩找到答案；
 *               所以需要补充一个拓展方式，即当 Si == Si+1 时，判断 Si-1 ?= Si+2,满足即拓展，不满足则结束。
 * @date: 2025/4/12 17:01
 * @param null
 * @return
 */
class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                int start = i - 1, end = i + 2, currentLength = 2;
                while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    currentLength += 2;
                    start--;
                    end++;
                }
                if (currentLength > maxLength) {
                    maxStart = start + 1;
                    maxLength = currentLength;
                }
            }
            int start = i - 1, end = i + 1, currentLength = 1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                currentLength += 2;
                start--;
                end++;
            }
            if (currentLength > maxLength) {
                maxStart = start + 1;
                maxLength = currentLength;
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
