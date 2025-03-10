//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2528 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 合并区间，只会出现5种情况，[L][R],[L[]R],[L[R]],[R[]L],[R][L],归纳为L_left <= R_right, R_right >= L_right;
 *               只需要对数组的首位进行排序即可解决第一个条件，所以只需要判断第二个条件是否满足，即可合并两个区间，并维护左右边界；
 * @date: 2025/3/10 15:24
 * @param null
 * @return
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        return getInts(intervals);
    }

    private static int[][] getInts(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i <= intervals.length; i++) {
            if (i < intervals.length && right >= intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
            } else {
                list.add(new int[]{left, right});
                if (i < intervals.length) {
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
