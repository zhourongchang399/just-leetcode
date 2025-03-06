//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 2163 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 分组，即提取数据集中每个数据的相似特征以区分它们，就可利用哈希表 key 不可重复（去重）的特点实现，
 *               首先提取目标数据的相似特征（异位词排序后相同，或异位词拆分每个单词后数量相同）作为 key，继而去哈希表中查询是否存在该 key
 *               若存在，则更新 Value（List<String>）, 否则，new List<String> 并写入当前数据，即可实现异位词分组功能
 * @date: 2025/3/6 14:43
 * @param null
 * @return
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 获取 char 数组
            char[] chars = str.toCharArray();
            // 排序
            Arrays.sort(chars);
            // 组装
            String key = new String(chars);
            List<String> currentList = map.getOrDefault(key, new ArrayList<String>());
            currentList.add(str);
            // 更新
            map.put(key, currentList);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
