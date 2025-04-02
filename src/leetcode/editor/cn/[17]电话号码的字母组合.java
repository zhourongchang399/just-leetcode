//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 3033 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 利用哈希表和数组存储电话号码上的字符，并通过每个数字的字符和后续数字字符两两互相拼接，直到路径末尾就回溯，回溯去除当前字符，并搜索当前数字下是否还有其他路径，直到回溯到起点即可。
 * @date: 2025/4/2 13:43
 * @param null
 * @return
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        Map<Character, Character[]> map = new HashMap<Character, Character[]>();
        map.put('2',new Character[]{'a','b','c'});
        map.put('3',new Character[]{'d','e','f'});
        map.put('4',new Character[]{'g','h','i'});
        map.put('5',new Character[]{'j','k','l'});
        map.put('6',new Character[]{'m','n','o'});
        map.put('7',new Character[]{'p','q','r','s'});
        map.put('8',new Character[]{'t','u','v'});
        map.put('9',new Character[]{'w','x','y','z'});
        myLetterCombinations(0, sb, digits, map, res);
        return res;
    }

    private void myLetterCombinations(int i, StringBuilder sb, String digits, Map<Character, Character[]> map, List<String> res) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char indexC = digits.charAt(i);
        for (Character c : map.get(indexC)) {
            sb.append(c);
            myLetterCombinations(i + 1, sb, digits, map, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
