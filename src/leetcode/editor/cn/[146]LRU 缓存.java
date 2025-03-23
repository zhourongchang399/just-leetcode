//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3433 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 哈希表存储 key 和 双向链表中的 node，node 存储 key 和 value，map 的 get 可以做到 O(1)，
 *               而双向链表可以存储操作记录，head 为 LRU，tail 为最新的操作记录，双向链表可以快速的删除和头尾插入。
 * @date: 2025/3/23 15:30
 * @param null
 * @return
 */
class LinkedListNode {
    int key;
    int value;
    LinkedListNode next;
    LinkedListNode prev;
    LinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    HashMap<Integer, LinkedListNode> map;
    int capacity = -1;
    LinkedListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            if (map.size() > 1) {
                LinkedListNode currentNode = map.get(key);
                if (head == currentNode) {
                    head = head.next;
                    head.prev = null;
                } else if (tail == currentNode) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    // 移除链表中的元素
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                // 将元素插入到末尾
                tail.next = currentNode;
                currentNode.prev = tail;
                tail = currentNode;
                tail.next = null;
            }
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkedListNode currentNode = map.get(key);
            if (map.size() > 1) {
                if (head == currentNode) {
                    head = head.next;
                    head.prev = null;
                } else if (tail == currentNode) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    // 移除链表中的元素
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                // 将元素插入到末尾
                tail.next = currentNode;
                currentNode.prev = tail;
                tail = currentNode;
                tail.next = null;
            }
            // 更新值
            currentNode.value = value;
        } else {
            LinkedListNode newNode = new LinkedListNode(key, value);
            if (map.size() >= capacity) {
                // 移除哈希表中的元素
                map.remove(head.key);
                // 移除链表中 LRU 元素
                head = head.next;
                head.prev = null;
                // 将元素插入到末尾
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                    head.next = tail;
                    tail.prev = head;
                } else {
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }
            }
            // 添加元素到哈希表中
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
