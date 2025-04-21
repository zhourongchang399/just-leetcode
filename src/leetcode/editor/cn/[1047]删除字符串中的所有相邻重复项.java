//给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 s 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 
//输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 栈 字符串 👍 695 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 利用栈，当空栈则入栈，非空栈则判断栈顶元素与当前元素是否相等，相等则出栈，最后将栈中元素依次由尾到头插入到新的 char[] 中，最后将其转换为 String。
 * @date: 2025/4/21 22:45
 * @param null
 * @return
 */
class Solution {
    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.addFirst(s.charAt(i));
            } else {
                stack.removeFirst();
            }
        }
        char[] chars = new char[stack.size()];
        for (int i = chars.length - 1; i >= 0; i--) {
            chars[i] = stack.removeFirst();
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
