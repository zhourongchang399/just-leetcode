//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 3240 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 不能连续偷，所以只能隔一家或者隔两家偷，即当前能够偷的最大值就是当前值加隔一家和隔两家后偷的最大值，即只需要从尾到头计算，计算出来后面路径最大值后即可得当前位置最大值。
 * @date: 2025/4/9 12:23
 * @param null
 * @return
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] profit = new int[nums.length];
        for(int i = nums.length - 1; i >=0; i--) {
            int afterOneProfit = i + 2 < nums.length ? profit[i + 2] : 0;
            int afterTwoProfit = i + 3 < nums.length ? profit[i + 3] : 0;
            profit[i] = nums[i] + Math.max(afterOneProfit, afterTwoProfit);
        }
        return Math.max(profit[0], profit[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
