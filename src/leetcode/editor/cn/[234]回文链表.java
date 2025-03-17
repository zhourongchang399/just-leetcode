//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 2032 👎 0


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
 * @description: 递归记录颠倒链表的值到数组中，利用头尾指针遍历数组即可；
 * @date: 2025/3/17 14:24
 * @param null
 * @return
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        List<Integer> reverseList = new ArrayList<>();
        reverseLinkedList(head, reverseList);
        int l = 0, r = reverseList.size() - 1;
        while (l < r) {
            if (reverseList.get(l++) != reverseList.get(r--)) {
                return false;
            }
        }
        return true;
    }

    public void reverseLinkedList(ListNode head, List<Integer> reverseList) {
        if(head == null || head.next == null) {
            if (head != null) {
                reverseList.add(head.val);
            }
            return;
        }
        reverseLinkedList(head.next, reverseList);
        reverseList.add(head.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
