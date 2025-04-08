//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", 
//"cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。 
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1272 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 遍历字符串记录每个字符的末尾位置，然后以字符串头字符作为子字符串开始位置 start，其最后出现位置为子字符串末尾位置 end；
 *               当 [start, end] 区间出现新的字符的末尾位置超过 end 则更新，知道 current 走到 end，记录结果并更新 start = end + 1;
 *               不断遍历字符串，知道末尾，即可得到答案。
 * @date: 2025/4/8 16:13
 * @param null
 * @return
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int current = 0;
        int end = map.get(s.charAt(start));
        while (current < s.length()) {
            end = Math.max(end, map.get(s.charAt(current)));
            if (current == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
            current++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
