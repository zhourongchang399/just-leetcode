//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1956 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 将无需重复插入的字符记录到 result 中，遇到数字字符则记录次数 count，遇到 [] 则通过栈记录有效括号的范围，再递归解码该范围内的子字符串并返回结果后重复插入 count 次，依次遍历字符串直到结尾。
 * @date: 2025/4/6 21:15
 * @param null
 * @return
 */
class Solution {
    public String decodeString(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            while (c >= 'a' && c <= 'z') {
                res.append(c);
                if (index >= s.length() - 1) break;
                c = s.charAt(++index);
            }
            if (index >= s.length() - 1) break;

            StringBuilder countString = new StringBuilder();
            while (c >= '0' && c <= '9') {
                countString.append(c);
                if (index >= s.length() - 1) break;
                c = s.charAt(++index);
            }
            if (index >= s.length() - 1) break;

            StringBuilder nextString = new StringBuilder();
            if (c == '[') {
                stack.push(c);
                c = s.charAt(++index);
                while (!stack.isEmpty()) {
                    if (c == '[') {
                        stack.push(c);
                    } else if (c == ']') {
                        stack.pop();
                        if (stack.isEmpty()) {
                            index++;
                            break;
                        }
                    }
                    nextString.append(c);
                    if (index >= s.length() - 1) break;
                    c = s.charAt(++index);
                }
                String subString = decodeString(nextString.toString());
                int count = Integer.parseInt(countString.toString());
                for (int i = 0; i < count; i++) {
                    res.append(subString);
                }
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
