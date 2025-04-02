//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// Related Topics 数组 回溯 👍 3009 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 组合总和，可以分为两种情况，第一就是保留当前位置数字进结果中，第二就是跳过当前位置数字继续搜寻后续所有可能路径；
 *               所以只需要每一层递归都分为两种情况遍历，最终走到 target <= pathSum 或者 index >= candidates.lengths 开始回溯更新 pathList；
 *               总结就是不断选择保留还是去除，即可包含所有可能结果，同时先排序 candidates 后根据当前位置值的大小判断是否剪枝，可以加速运算。
 * @date: 2025/4/2 22:09
 * @param null
 * @return
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        myCombinationSum(list, res, candidates, target, 0);
        return res;
    }

    private void myCombinationSum(List<Integer> list, List<List<Integer>> res, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else if (target < 0 || index >= candidates.length) {
            return;
        }
        if (candidates[index] > target) {
            return;
        }
        myCombinationSum(list, res, candidates, target, index + 1);
        if (index <= candidates.length - 1) {
            list.add(candidates[index]);
            myCombinationSum(list, res, candidates, target - candidates[index], index);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
