//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2982 👎 0


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
 * @description: 利用归并排序的思想，省去拆分链表的步骤，补全合并逻辑即可。
 * @date: 2025/3/23 13:27
 * @param null
 * @return
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0) return null;
        if(len == 1) return lists[0];
        int i = 0;
        ListNode[] ans = new ListNode[(len + 1) / 2];

        while (i < len) {
            ListNode left = lists[i];
            if (i + 1 >= len) {
                ans[i / 2] = left;
                break;
            }
            ListNode right = lists[i + 1];
            ListNode merge = mergeLRList(left, right);
            ans[i / 2] = merge;
            i += 2;
        }

        return mergeKLists(ans);

    }

    private ListNode mergeLRList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }

        while (left != null) {
            dummy.next = left;
            left = left.next;
            dummy = dummy.next;
        }

        while (right != null) {
            dummy.next = right;
            right = right.next;
            dummy = dummy.next;
        }

        return head.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
