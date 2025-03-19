//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 11163 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * @author: Zc
 * @description: 两数相加，从尾到头相加，链表已经逆序所以只需头结点开始相加，保留多出的值，累计到下一位，按照数学运算即可。
 * @date: 2025/3/19 21:24
 * @param null
 * @return
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode currentPointer = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int add = l1.val + l2.val + carry;
            currentPointer.next = new ListNode(add % 10);
            carry = add / 10;
            currentPointer = currentPointer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int add = l1.val + carry;
            currentPointer.next = new ListNode(add % 10);
            carry = add / 10;
            currentPointer = currentPointer.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int add = l2.val + carry;
            currentPointer.next = new ListNode(add % 10);
            carry = add / 10;
            currentPointer = currentPointer.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            currentPointer.next = new ListNode(carry);
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
