//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1614 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: 只需要找到所有固定长度的子串和目标比对是否是异位词即可，遍历s的charArray即可得到所有子串；
 *          而判断是否是异位词则是重点，两个数组分别记录 target 和 currentString 的字符数量，再判断两个数组即可；
 * @description: TODO
 * @date: 2025/3/7 20:46
 * @param null
 * @return
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        int[] pChars = new int[26];
        int[] sChars = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pChars[p.charAt(i) - 'a']++;
            sChars[s.charAt(i) - 'a']++;
        }

        int left = 0, right = p.length();

        if (Arrays.equals(sChars, pChars)) {
            ans.add(left);
        }

        while (left < s.length() - p.length()) {
            sChars[s.charAt(right++) - 'a']++;
            sChars[s.charAt(left++) - 'a']--;

            if (Arrays.equals(sChars, pChars)) {
                ans.add(left);
            }

        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
