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
 * @description: 遍历数组记录每个字符的区间，然后对区间列表排序，最后合并区间，计算每个区间的长度。
 * @date: 2025/4/8 16:13
 * @param null
 * @return
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        ArrayList<int[]> list = new ArrayList<>();
        charRange(s, map);

        list.addAll(map.values());
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> merged = new ArrayList<>();
        for (int[] right : list) {
            if (merged.isEmpty()) {
                merged.add(right);
            } else {
                int[] left = merged.get(merged.size() - 1);
                if ((left[0] < right[0] && left[1] > right[0]) || (left[0] < right[1] && left[1] > right[1])) {
                    int[] newArr = new int[2];
                    newArr[0] = Math.min(left[0], right[0]);
                    newArr[1] = Math.max(left[1], right[1]);
                    merged.remove(merged.size() - 1);
                    merged.add(newArr);
                } else {
                    merged.add(right);
                }
            }
        }

        merged.forEach(arr -> {
            res.add(arr[1] - arr[0] + 1);
        });
        return res;
    }

    private static void charRange(String s, HashMap<Character, int[]> map) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int[] arr = map.get(c);
                arr[1] = i;
                map.put(c, arr);
            } else {
                map.put(c, new int[]{i, i});
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
