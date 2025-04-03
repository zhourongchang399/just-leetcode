//给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2021 👎 0

/**
 * @author: Zc
 * @description: 分割回文串，判断当前位置截取 len 长度的子串是否是回文串，是则添加到当前路径，不是则增加长度，直到 index 指向末尾，或者 index + len > s.length() 开始回溯；
 *               回溯去除末尾路径值，并搜索当前位置 len + i 的子串是否是回文串，不断回溯即可得到答案。
 * @date: 2025/4/3 15:18
 * @param null
 * @return
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return new ArrayList<List<String>>();
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> currentPath = new ArrayList<>();
        myPartition(currentPath, res, s, 0);
        return res;
    }

    private void myPartition(List<String> currentPath, List<List<String>> res, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(currentPath));
        }
        for (int i = 1; i <= s.length() && index + i <= s.length(); i++) {
            String substring = s.substring(index, index + i);
            if (reverseString(substring)) {
                currentPath.add(substring);
                myPartition(currentPath, res, s, index + i);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    private boolean reverseString(String substring) {
        int l = 0, r = substring.length() - 1;
        while (l < r) {
            if (substring.charAt(l) != substring.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
