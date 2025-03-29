//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 1780 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author: Zc
 * @description: insert 即构建27叉树（26个小写英文字母，一个单词结束符），使用哈希表存储 key:char，value:Trie;
 *               search 即根据检索词遍历每一个字符，即搜索 hashTable 中是否存在当前字符，并且结束是是否包含结束符；
 *               startWith 即与 search 功能一致，但是不需要判断是否包含结束符。
 * @date: 2025/3/29 15:31
 * @param null
 * @return
 */
class Trie {
    HashMap<Character, Trie> children;

    public Trie() {
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            children.put('!', null);
            return;
        }
        if (!children.containsKey(word.charAt(0))) {
            children.put(word.charAt(0), new Trie());
        }
        children.get(word.charAt(0)).insert(word.substring(1, word.length()));
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return children.containsKey('!');
        }
        if (children.containsKey(word.charAt(0))) {
            return children.get(word.charAt(0)).search(word.substring(1, word.length()));
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return true;
        }
        if (children.containsKey(prefix.charAt(0))) {
            return children.get(prefix.charAt(0)).startsWith(prefix.substring(1, prefix.length()));
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
