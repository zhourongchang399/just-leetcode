//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
// 
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
// 
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 965 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: 利用哈希表和优先队列实现按照字典顺序排列的图，再采用 DFS 遍历图；
 *               因为一定存在有效行程，所以即使当前节点某一路径无法走完全部余下路径；
 *               也可以通过继续遍历当前节点其余路径完全走完余下路径；
 *               但是这些路径如果按照走哪插哪的方式，则最后路径一定不是有效的；
 *               所以需要通过前插法，即当前节点已无任何跳转节点才插入到 path 的头部;
 *               这样无论优先遍历任一路径，都可重新构成完整路径，同时保持字典顺序。
 * @date: 2025/4/27 15:37
 * @param null
 * @return
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> path = new ArrayList<>();
        myFindItinerary("JFK", tickets, map, path);
        return path;
    }

    private void myFindItinerary(String pre, List<List<String>> tickets, Map<String, PriorityQueue<String>> map, List<String> path) {
        PriorityQueue<String> visited = map.get(pre);
        while (visited != null && !visited.isEmpty() ) {
            myFindItinerary(visited.poll(), tickets, map, path);
        }
        path.add(0, pre);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
