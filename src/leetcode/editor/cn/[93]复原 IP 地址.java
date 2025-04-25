//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1508 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 递归回溯，剪枝（1：0 开头的非位数；2：后续剩余位数不满足 ip 地址构造条件；3：当前值满足 0 <= ? <= 255）。
 * @date: 2025/4/25 15:43
 * @param null
 * @return
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        List<Integer> path = new ArrayList<>();
        myRestoreIpAddresses(s, 0, 0, path, res);
        return res;
    }

    private void myRestoreIpAddresses(String s, int index, int k, List<Integer> path, List<String> res) {
        if (k == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }
        for (int i = 1; i < 4 && index + i <= s.length(); i++) {
            if (i > 1 && s.charAt(index) == '0') {
                break;
            }
            int value = Integer.parseInt(s.substring(index, index + i));
            if (value < 0 || value > 255 || s.length() - index - i > (3 - k) * 3) {
                continue;
            }
            path.add(value);
            myRestoreIpAddresses(s, index + i, k + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
