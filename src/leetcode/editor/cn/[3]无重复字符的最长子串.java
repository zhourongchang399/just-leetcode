//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10658 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 最直接的解法是暴力遍历所有子串，检查是否有重复字符，但是每次都需要从第i个位置开始重复遍历i-1已经走过的位置，
 *               所以只需要记录上一个位置到那里出现了重复字符的位置，就可以从避免重复计算，所以采用双指针算法，
 *               右指针指向上一个子串出现重复字符的截至位置，左指针则指向子串开始位置，校验子串是否重复则采用哈希表去重的方式。
 * @date: 2025/3/7 17:34
 * @param null
 * @return
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int maxLen = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
