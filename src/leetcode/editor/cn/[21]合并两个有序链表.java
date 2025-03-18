//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3721 👎 0


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
 * @description: 遍历两个链表，满足条件的链表的值作为新链表的 next，并满足条件的链表向后走一步，直至两个链表遍历完全。
 * @date: 2025/3/18 15:23
 * @param null
 * @return
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode pointerHead = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointerHead.next = list1;
                list1 = list1.next;
            } else {
                pointerHead.next = list2;
                list2 = list2.next;
            }
            pointerHead = pointerHead.next;
        }

        while (list1 != null) {
            pointerHead.next = list1;
            list1 = list1.next;
            pointerHead = pointerHead.next;
        }

        while (list2 != null) {
            pointerHead.next = list2;
            list2 = list2.next;
            pointerHead = pointerHead.next;
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
