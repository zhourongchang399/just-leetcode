//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 3068 👎 0


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
 * @description: 删除链表的倒数第 N 个结点，通过递归链表，从尾到头遍历，每次 n-1，当 n == 0 时，
 *               将当前结点的下一节点去除，当递归结束，n >= 0 即删除头结点。
 * @date: 2025/3/19 21:46
 * @param null
 * @return
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int k = reverseRemove(head, n);
        if (k >= 0) {
            head = head.next;
        }
        return head;
    }

    public int reverseRemove(ListNode head, int n) {
        if (head == null || head.next == null) return n - 1;
        n = reverseRemove(head.next, n);
        if (n == 0) {
            head.next = head.next.next;
        }
        return n - 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
