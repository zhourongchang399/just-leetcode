//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 673 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 模拟，每次跳 2 * k 步，当 index += 2 * k 依旧在范围内，则反转对应子字符串，并拼接后续 k 位子字符串；
 *               当 index > s.length() && index - k + 1 < s.length();
 *               则代表着还有小于 k 位的子字符串未纳入反转，继续反转该子字符串即可得到最终答案。
 * @date: 2025/4/20 22:37
 * @param null
 * @return
 */
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int index = k - 1;
        while (index < s.length()) {
            for (int i = index; i >= index - k + 1; i--) {
                sb.append(s.charAt(i));
            }
            for (int i = index + 1; i <= index + k && i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
            index += 2 * k;
        }
        if (index - k + 1 < s.length()) {
            for (int i = s.length() - 1; i >= index - k + 1; i--) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
