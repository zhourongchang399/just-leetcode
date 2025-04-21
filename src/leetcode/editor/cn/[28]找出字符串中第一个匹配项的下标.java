//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2400 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: KMP算法，当出现字符串不匹配时，可以记录一部分之前已经匹配的文本内容，利用这些信息避免从头再去做匹配；
 *               具体实现：即当两个字符串出现不匹配时，当前位置的前序子串的公共前后缀可以跳过,例如，ABC___ABC 中的 ABC 是可以跳过的；
 *               所以只需记录匹配字符串的 next[] 数组，记录当前位置的前序子串的最长公共前后缀数，既可以跳过这些前缀。
 *               而 next[] 数组的计算，则可以通过遍历，当前一位 next 不为 0，即可能出现更长的公共前后缀数，假若不是；
 *               则通过前一位的公共前后缀数可以知道，他对应的前缀位置，和前缀位置的最长公共前后缀数，即他的前缀可以是当前位置的初始长度，
 *               假如后一位继续相等，则可以 +1，否则比对首位即可，首位也不等，则匹配字符串从头开始。
 * @date: 2025/4/21 17:50
 * @param null
 * @return 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        for (int i = 1; i < needle.length(); i++) {
            if (next[i - 1] > 0) {
                if (needle.charAt(next[i - 1]) == needle.charAt(i)) {
                    next[i] = next[i - 1] + 1;
                } else if (needle.charAt(next[next[i - 1] - 1]) == needle.charAt(i)) {
                    next[i] = next[next[i - 1] - 1] + 1;
                }
            } else {
                if (needle.charAt(0) == needle.charAt(i)) {
                    next[i] = 1;
                }
            }
        }

        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - needle.length() + 1;
                }
                j++;
            } else {
                if (j != 0) {
                    j = next[j - 1];
                    i--;
                } else {
                    j = 0;
                }
            }
            i++;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
