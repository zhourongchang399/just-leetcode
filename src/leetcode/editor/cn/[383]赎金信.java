//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 965 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 用数组记录 ransomNote 出现的每个字符的次数，在减去 magazine 中字符出现的次数，当数组中存在正数则代表杂志的字符不足以构成赎金信，否则不然。
 * @date: 2025/4/19 17:46
 * @param null
 * @return
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            counts[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
