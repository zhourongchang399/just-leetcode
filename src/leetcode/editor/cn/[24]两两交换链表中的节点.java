//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2381 👎 0


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
 * @description: 记录两两交换其中相邻的节点的前一节点，交换两节点后前一节点指向交换后的头节点，遍历到链表尾部。
 * @date: 2025/3/20 15:59
 * @param null
 * @return
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode currentPointer = head;
        ListNode currentHead = result;
        while (currentPointer != null) {
            if (currentPointer == null || currentPointer.next == null) {
                return result.next;
            }
            ListNode nextNode = currentPointer.next;
            currentPointer.next = nextNode.next;
            nextNode.next = currentPointer;
            currentHead.next = nextNode;
            currentHead = currentPointer;
            currentPointer = currentPointer.next;
        }
        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
