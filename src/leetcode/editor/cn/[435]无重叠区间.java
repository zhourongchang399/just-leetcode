//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 1215 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 先首位降序排序，一样则末位降序排序，遍历数组，去除首位相同区间，首位不同则判断是否包含，包含则保留区间小的，不包含而是重叠则去除，如果不是重叠则更新当前区间，直到末尾。
 * @date: 2025/5/11 23:22
 * @param null
 * @return
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> collect = Arrays.stream(intervals).sorted((a, b) -> {return a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);}).collect(Collectors.toList());
        int res = 0;
        int[] current = null;
        for (int[] interval : collect) {
            if (current == null) {
                current = interval;
            } else {
                if (current[0] != interval[0]) {
                    if (current[1] <= interval[0]) {
                        current = interval;
                    } else {
                        res++;
                        if (current[1] >= interval[1]) {
                            current = interval;
                        }
                    }
                } else {
                    res++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
