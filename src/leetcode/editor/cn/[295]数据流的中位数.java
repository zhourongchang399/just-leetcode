//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。 
//
// 
// 例如 arr = [2,3,4] 的中位数是 3 。 
// 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。 
// 
//
// 实现 MedianFinder 类: 
//
// 
// MedianFinder() 初始化 MedianFinder 对象。 
// void addNum(int num) 将数据流中的整数 num 添加到数据结构中。 
// double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。 
// 
//
// 示例 1： 
//
// 
//输入
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//输出
//[null, null, null, 1.5, null, 2.0]
//
//解释
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0 
//
// 提示: 
//
// 
// -10⁵ <= num <= 10⁵ 
// 在调用 findMedian 之前，数据结构中至少有一个元素 
// 最多 5 * 10⁴ 次调用 addNum 和 findMedian 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 1107 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 寻找数据流的中位数，即需要不断维护一个保存以中位数为分界的相对顺序的数据结构，同时还要保证插入和检索中位数的复杂度足够低；
 *               考虑使用一个大根堆存储中位数左边的数值，堆顶保持为数据流中一半的相对最小值，即堆顶可能是中位数，也可能是求中位数的小值的那一半；
 *               再使用一个小根堆存储中位数右边的数值，堆顶保持为数据流中一半的相对最最值，即堆顶可能是中位数，也可能是求中位数的大值的一半；
 *               答案即：当两个堆大小一样，则取大根堆的堆顶元素和小根堆的堆顶元素求平均，当大小差一则是大小大的那个堆的堆顶元素；
 *               即需要维持两个堆大小最大不能超过 1，所以需要判断并不断更新两个堆。
 * @date: 2025/4/8 0:38
 * @param null
 * @return
 */
class MedianFinder {

    ArrayList<Integer> bigHeap = null;
    ArrayList<Integer> smallHeap = null;

    public MedianFinder() {
        bigHeap = new ArrayList<>();
        smallHeap = new ArrayList<>();
    }

    public void addNum(int num) {
        if (smallHeap.size() == bigHeap.size() - 1) {
            if (bigHeap.get(0) > num) {
                int temp = bigHeap.get(0);
                bigHeap.set(0, bigHeap.get(bigHeap.size() - 1));
                bigHeap.set(bigHeap.size() - 1, temp);
                bigHeapDownFilter(bigHeap, 0, bigHeap.size() - 1);
                insertSmallHeap(bigHeap.remove(bigHeap.size() - 1));
                insertBigHeap(num);
            } else {
                insertSmallHeap(num);
            }
        } else if (bigHeap.size() == smallHeap.size() - 1) {
            if (smallHeap.get(0) < num) {
                int temp = smallHeap.get(0);
                smallHeap.set(0, smallHeap.get(smallHeap.size() - 1));
                smallHeap.set(smallHeap.size() - 1, temp);
                smallHeapDownFilter(smallHeap, 0, smallHeap.size() - 1);
                insertBigHeap(smallHeap.remove(smallHeap.size() - 1));
                insertSmallHeap(num);
            } else {
                insertBigHeap(num);
            }
        } else if (bigHeap.size() == smallHeap.size()) {
            if (bigHeap.size() == 0 || bigHeap.get(0) < num) {
                insertSmallHeap(num);
            } else {
                insertBigHeap(num);
            }
        }
    }

    public double findMedian() {
        int len = bigHeap.size() + smallHeap.size();
        if (len % 2 == 0) {
            return (bigHeap.get(0) + smallHeap.get(0)) / 2.0;
        } else {
            return bigHeap.size() > smallHeap.size() ? bigHeap.get(0) : smallHeap.get(0);
        }
    }

    public void insertSmallHeap(int num) {
        smallHeap.add(num);
        int len = smallHeap.size();
        int target = len - 1;
        while (target > 0 && smallHeap.get((target - 1) / 2) > smallHeap.get(target)) {
            int temp = smallHeap.get(target);
            smallHeap.set(target, smallHeap.get((target - 1) / 2));
            smallHeap.set((target - 1) / 2, temp);
            target = (target - 1) / 2;
        }
    }

    public void insertBigHeap(int num) {
        bigHeap.add(num);
        int len = bigHeap.size();
        int target = len - 1;
        while (target > 0 && bigHeap.get((target - 1) / 2) < bigHeap.get(target)) {
            int temp = bigHeap.get(target);
            bigHeap.set(target, bigHeap.get((target - 1) / 2));
            bigHeap.set((target - 1) / 2, temp);
            target = (target - 1) / 2;
        }
    }

    public void smallHeapDownFilter(ArrayList<Integer> list, int targetIndex, int len) {
        while (2 * targetIndex + 1 < len) {
            int minIndex = 2 * targetIndex + 1;
            if (2 * targetIndex + 2 < len) {
                minIndex = list.get(minIndex) < list.get(2 * targetIndex + 2) ? minIndex : 2 * targetIndex + 2;
            }
            if (list.get(targetIndex) > list.get(minIndex)) {
                int temp = list.get(targetIndex);
                list.set(targetIndex, list.get(minIndex));
                list.set(minIndex, temp);
            }
            targetIndex = minIndex;
        }
    }

    public void bigHeapDownFilter(ArrayList<Integer> list, int targetIndex, int len) {
        while (2 * targetIndex + 1 < len) {
            int maxIndex = 2 * targetIndex + 1;
            if (2 * targetIndex + 2 < len) {
                maxIndex = list.get(maxIndex) >= list.get(2 * targetIndex + 2) ? maxIndex : 2 * targetIndex + 2;
            }
            if (list.get(targetIndex) < list.get(maxIndex)) {
                int temp = list.get(targetIndex);
                list.set(targetIndex, list.get(maxIndex));
                list.set(maxIndex, temp);
            }
            targetIndex = maxIndex;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
