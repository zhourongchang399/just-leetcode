//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2726 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 采用字典树记录字典，当前位置 targetIndex 到 length - 1 的子字符串满足单词拆分则 dp[targetIndex] = true, 即对当前位置，i for targetIndex to length - 1;
 *               dp[targetIndex] = tree.search(subString(targetIndex, i)) && dp[i + 1]。也可直接使用 HashSet 记录字典，简化构建字典树，和检索拆分单词是否存在的步骤。
 * @date: 2025/4/10 23:20
 * @param null
 * @return
 */
class Solution {
    class Dictionary {
        HashMap<Character, Dictionary> wordTree = null;

        public Dictionary() {
            wordTree = new HashMap<>();
        }

        public void addWord(String word) {
            if (word.isEmpty()) {
                wordTree.put('!', new Dictionary());
                return;
            };
            if (!wordTree.containsKey(word.charAt(0))) {
                wordTree.put(word.charAt(0), new Dictionary());
            }
            wordTree.get(word.charAt(0)).addWord(word.substring(1));
        }

        public boolean search(String word) {
            if (word.isEmpty()) {
                if (wordTree.containsKey('!'))
                    return true;
                else
                    return false;
            }
            if (!wordTree.containsKey(word.charAt(0))) {
                return false;
            }
            return wordTree.get(word.charAt(0)).search(word.substring(1));
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
//        Dictionary dict = new Dictionary();
//        for (String word : wordDict) {
//            dict.addWord(word);
//        }

        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        Boolean[] dp = new Boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                dp[i] = dp[j] && set.contains(s.substring(i, j));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
