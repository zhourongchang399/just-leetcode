//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3170 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 最小覆盖子串，类似于最长不重复子串，利用滑动窗口右指针一直遍历到符合的子串为止，左指针则一直遍历到不符合的子串为止，
 *               则左右指针指向的子串为符合的子串，只需要记录 left 和 维护最短长度，即可最后截取 String，同时，利用哈希表和 count
 *               来识别是否是合法子串，count 代表不符合的字符个数，同时哈希表只应该记录 t 的字符，这样在遍历 s 字符串的时候多余的字符可以忽略；
 * @date: 2025/3/9 22:47
 * @param null
 * @return
 */
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || t.length() > s.length()) return "";
        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = map.size();

        while (left < s.length()) {
            if (count > 0 && right < s.length()) {
                if (map.containsKey(s.charAt(right))) {
                    if (map.get(s.charAt(right)) == 1) {
                        count--;
                    }
                    map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                }
                right++;
            } else {
                if (count == 0 && right - left < minLen) {
                    start = left;657777777777777
                    minLen = right - left;
                }
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) == 0) {
                        count++;
                    }
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
