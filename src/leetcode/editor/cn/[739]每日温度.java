//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1934 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 利用单调栈记录每日温度的数组下标，当新一天的温度比栈顶元素对应的该日温度大，则计算当前他们之间的差值，并出栈，直到新温度插入依旧满足单调栈为止，一直遍历温度数组并更新栈即得到答案。
 * @date: 2025/4/6 22:10
 * @param null
 * @return
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stacks = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stacks.isEmpty()) {
                if (temperatures[stacks.peek()] < temperatures[i]) {
                    res[stacks.peek()] = i - stacks.peek();
                    stacks.pop();
                } else {
                    break;
                }
            }
            stacks.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
