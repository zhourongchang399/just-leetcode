//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4689 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 利用栈先进后出的特性，栈顶和后续字符是有效的括号对则出栈，否则入栈，最后判断栈是否为空即可。
 * @date: 2025/4/6 13:48
 * @param null
 * @return 
 */
class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                    continue;
                } else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                    continue;
                } else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
