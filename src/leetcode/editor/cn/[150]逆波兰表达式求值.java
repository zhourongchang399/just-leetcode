//给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。 
//
// 请你计算该表达式。返回一个表示表达式值的整数。 
//
// 注意： 
//
// 
// 有效的算符为 '+'、'-'、'*' 和 '/' 。 
// 每个操作数（运算对象）都可以是一个整数或者另一个表达式。 
// 两个整数之间的除法总是 向零截断 。 
// 表达式中不含除零运算。 
// 输入是一个根据逆波兰表示法表示的算术表达式。 
// 答案及所有中间计算结果可以用 32 位 整数表示。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 
//输入：tokens = ["4","13","5","/","+"]
//输出：6
//解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 
//输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//输出：22
//解释：该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
//
// 
//
// 提示： 
//
// 
// 1 <= tokens.length <= 10⁴ 
// tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数 
// 
//
// 
//
// 逆波兰表达式： 
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。 
//
// 
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。 
// 
//
// 逆波兰表达式主要有以下两个优点： 
//
// 
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。 
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中 
// 
//
// Related Topics 栈 数组 数学 👍 1001 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 逆波兰表达式即对二叉树的后序遍历，只需将二叉树中序遍历即为数学运算表达式；
 *               因为叶子结点必为数字，运算符必为根结点，所以当遇到运算符时，他的前面两位必为其左右子树的运算结果；
 *               所以只需通过栈依次由由头到为入栈，当遇到运算符则计算他们的前二位运算结果，相当于递归，先运算可计算的，再汇总结果计算下一步。
 * @date: 2025/4/21 22:59
 * @param null
 * @return
 */
class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.addFirst(stack.removeFirst() + stack.removeFirst());
            } else if (token.equals("-")) {
                int right = stack.removeFirst();
                int left = stack.removeFirst();
                stack.addFirst(left - right);
            } else if (token.equals("*")) {
                stack.addFirst(stack.removeFirst() * stack.removeFirst());
            } else if (token.equals("/")) {
                int right = stack.removeFirst();
                int left = stack.removeFirst();
                stack.addFirst(left / right);
            } else {
                stack.addFirst(Integer.parseInt(token));
            }
        }
        return stack.removeFirst();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
