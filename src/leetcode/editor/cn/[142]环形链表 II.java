//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
//
// Related Topics 哈希表 链表 双指针 👍 2763 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * @author: Zc
 * @description: 快指针和慢指针相遇的地方，一个新指针从头结点开始走到与慢指针相遇的地方即是环链入口处；
 *               a:头结点-入口处，b:入口处-相遇点，c:相遇点-入口处，n:快指针走过的圈数（快指针只有套圈才可追上慢指针）；
 *               slow:a+b,fast:a+b+n(b+c),2slow=fast，即2(a+b)=a+b+n(b+c)->a=n(b+c)-b；
 *               当只套一圈时：a=c，即慢指针继续走会和一个新的从头结点开始走的指针在入口处相遇；
 *               当套两圈时：a=(b+c)+c,即慢指针继续走一圈并且再走c的距离即可再入口处与新指针相遇；
 *               当套n圈时：a=(n-1)(b+c)+c,即慢指针继续走(n-1)圈回到相遇点，再走c的距离即可再入口处与新指针相遇；
 *               以此类推，慢指针只需按部就班走到与新指针相遇的地方必定是入口处。
 * @date: 2025/3/18 14:54
 * @param null
 * @return
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer == slowPointer) {
                ListNode enterPointer = head;
                while (enterPointer != slowPointer) {
                    enterPointer = enterPointer.next;
                    slowPointer = slowPointer.next;
                }
                return enterPointer;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
