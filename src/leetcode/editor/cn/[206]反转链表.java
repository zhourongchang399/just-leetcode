//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
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
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3832 👎 0


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
 * @description: 遍历链表，存储当前节点为头节点，并替换头结点的 next 为上一轮头结点，再更新当前节点为其下一节点，即可得到答案；
 * @date: 2025/3/16 20:23
 * @param null
 * @return
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 遍历
//        ListNode result = null;
//        ListNode temp = null;
//        while (head != null) {
//            temp = result;
//            result = head;
//            head = head.next;
//            result.next = temp;
//        }
//        return result;

        // 递归

        // 只要递归到最后一个节点
        if(head == null || head.next == null) return head;

        // 获取下一个节点
        ListNode nextHead = reverseList(head.next);

        // 当前节点和下一节点形成一个环
        head.next.next = head;

        // 破圈
        head.next = null;

        // 返回头结点
        return nextHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
