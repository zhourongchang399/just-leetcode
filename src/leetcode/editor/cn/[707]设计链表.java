//你可以选择使用单链表或者双链表，设计并实现自己的链表。 
//
// 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。 
//
// 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。 
//
// 实现 MyLinkedList 类： 
//
// 
// MyLinkedList() 初始化 MyLinkedList 对象。 
// int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。 
// void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。 
// void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。 
// void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 
//index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。 
// void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", 
//"deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//输出
//[null, null, null, null, 2, null, 3]
//
//解释
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//myLinkedList.get(1);              // 返回 2
//myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//myLinkedList.get(1);              // 返回 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= index, val <= 1000 
// 请不要使用内置的 LinkedList 库。 
// 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。 
// 
//
// Related Topics 设计 链表 👍 1134 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 设计双向链表
 * @date: 2025/4/19 14:52
 * @param null
 * @return
 */
class MyLinkedList {

    Node head = null;
    Node tail = null;
    int size = 0;

    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        if (size == 0) {
            head = new Node(val);
            head.next = null;
            tail = head;
            tail.prev = null;
        } else if (size == 1) {
            Node beforeHead = head;
            head = new Node(val);
            head.next = beforeHead;
            tail = beforeHead;
            tail.prev = head;
            tail.next = null;
        } else {
            Node beforeHead = head;
            head = new Node(val);
            head.next = beforeHead;
            beforeHead.prev = head;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            head = new Node(val);
            head.next = null;
            tail = head;
            tail.prev = null;
        } else if (size == 1) {
            Node beforeTail = tail;
            tail = new Node(val);
            tail.prev = beforeTail;
            beforeTail.next = tail;
            head = beforeTail;
        } else {
            Node beforeTail = tail;
            tail = new Node(val);
            tail.prev = beforeTail;
            beforeTail.next = tail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        } else if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        } else {
            Node cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node beforeNext = cur.next;
            cur.next = new Node(val);
            cur.next.prev = cur;
            cur.next.next = beforeNext;
            if (beforeNext != null) {
                beforeNext.prev = cur.next;
            }
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            tail = tail.prev;
        } else {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
