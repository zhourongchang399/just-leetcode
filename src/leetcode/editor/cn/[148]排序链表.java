//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2479 👎 0


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
 * @description: 排序链表使用归并排序，将链表划分为最小单位的有序链表，再把相邻有序链表合并为一个更大的有序链表，以此往复；
 *               通过递归将大链表划分为左右子链表（快慢指针），直到无法再分则返回最小单位链表，再通过逆递归合并子链表，最终合并为最初大小的链表。
 * @date: 2025/3/21 18:21
 * @param null
 * @return
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        return sortLinkedList(head);
    }

    private ListNode sortLinkedList(ListNode head) {
        if (head.next == null) return head;
        // 拆分左右链表
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode leftList = head;
        ListNode rightList = slow.next;
        slow.next = null;

        // 排序左子链表
        leftList = sortLinkedList(leftList);

        // 排序右子链表
        rightList = sortLinkedList(rightList);

        // 合并左右子链表
        return mergeLRList(leftList, rightList);
    }

    private ListNode mergeLRList(ListNode leftList, ListNode rightList) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (leftList != null && rightList != null) {
            if (leftList.val < rightList.val) {
                dummy.next = leftList;
                leftList = leftList.next;
            } else {
                dummy.next = rightList;
                rightList = rightList.next;
            }
            dummy = dummy.next;
        }

        while (leftList != null) {
            dummy.next = leftList;
            dummy = dummy.next;
            leftList = leftList.next;
        }

        while (rightList != null) {
            dummy.next = rightList;
            dummy = dummy.next;
            rightList = rightList.next;
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
