//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
//
// Related Topics 栈 设计 👍 1908 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: MinStack 使用内部类来声明节点，并构建链表，以实现栈的基本功能，同时为了实现最小栈，利用 LinkedList 记录最小节点，push 和 pop 操作时都对 LinkedList 更新，获取最小值时，只需获取 LinkedList 的栈顶元素。
 * @date: 2025/4/6 18:26
 * @param null
 * @return
 */
class MinStack {

    Node head = null;
    LinkedList<Integer> minStack = null;

    class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }
    }

    public MinStack() {
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        minStack.pop();
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
