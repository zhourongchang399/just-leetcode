//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 1282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 暴力解法：只需要搜索 1-2/n 长度的子串是否满足条件即可；
 *               移动补偿：去掉头尾的 s + s 的新字符串，如果他们可以由重复子字符串组成；
 *               则他们一定可以在中间找到 s，利用 KMP 算法，否则不然。
 * @date: 2025/4/21 21:26
 * @param null
 * @return
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0) continue;
            boolean flag = true;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
