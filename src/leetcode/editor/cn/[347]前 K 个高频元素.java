//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1993 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 先用哈希表统计数字出现的数量，再堆哈希表的 key 根据其 value 建大根堆，最后每次取堆顶元素 key 插入 result 数组，并去除堆顶元素，交换头尾元素，重新对堆顶元素下滤，重复 k 次。
 * @date: 2025/4/7 21:46
 * @param null
 * @return
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个数字出现的数量
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
                list.add(nums[i]);
            }
        }

        // 建堆
        int len = list.size();
        int nodeIndex = len / 2 - 1;
        for (int i = nodeIndex; i >= 0; i--) {
            downFilter(i, len, map, list);
        }

        // 堆排序
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(0);
            int temp = list.get(0);
            list.set(0, list.get(len - 1));
            list.set(len - 1, temp);
            len--;
            downFilter(0, len, map, list);
        }

        return ans;
    }

    private static void downFilter(int targetIndex, int len, Map<Integer, Integer> map, ArrayList<Integer> list) {
        while (2 * targetIndex + 1 < len) {
            int maxIndex = 2 * targetIndex + 1;
            if (2 * targetIndex + 2 < len) {
                maxIndex = map.get(list.get(maxIndex)) >= map.get(list.get(2 * targetIndex + 2)) ? maxIndex : 2 * targetIndex + 2;
            }
            if (map.get(list.get(targetIndex)) < map.get(list.get(maxIndex))) {
                int temp = list.get(targetIndex);
                list.set(targetIndex, list.get(maxIndex));
                list.set(maxIndex, temp);
            }
            targetIndex = maxIndex;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
