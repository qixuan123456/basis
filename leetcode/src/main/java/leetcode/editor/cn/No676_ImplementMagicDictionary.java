//设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单
//词存在于你构建的字典中。 
//
// 实现 MagicDictionary 类： 
//
// 
// MagicDictionary() 初始化对象 
// void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字
//符串互不相同 
// bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得
//所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入
//["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
//输出
//[null, null, false, true, false, false]
//
//解释
//MagicDictionary magicDictionary = new MagicDictionary();
//magicDictionary.buildDict(["hello", "leetcode"]);
//magicDictionary.search("hello"); // 返回 False
//magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//magicDictionary.search("hell"); // 返回 False
//magicDictionary.search("leetcoded"); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 100 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写英文字母组成 
// dictionary 中的所有字符串 互不相同 
// 1 <= searchWord.length <= 100 
// searchWord 仅由小写英文字母组成 
// buildDict 仅在 search 之前调用一次 
// 最多调用 100 次 search 
// 
// 
// 
// 
// Related Topics 设计 字典树 哈希表 字符串 👍 154 👎 0

package leetcode.editor.cn;

import java.util.*;
/**
  * 题目Id：676; 
  * 题目：实现一个魔法字典，implement-magic-dictionary; 
  * 日期：2022-07-11 14:22:32
*/

public class No676_ImplementMagicDictionary{
    public static void main(String[] args) {
        MagicDictionary solution = new MagicDictionary();
        solution.buildDict(new String[]{"hello"});
        System.out.println(solution.search("hhllo"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
static class MagicDictionary {
    static class TrieNode{
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
    TrieNode root ;

    public void add(String s){
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i)-'a';
            if(node.children[a]==null){
                node.children[a] = new TrieNode();
            }
            node = node.children[a];
        }
        node.isEnd = true;
    }

    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            add(dictionary[i]);
        }
    }
    
    public boolean search(String searchWord) {
        TrieNode node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            int a = searchWord.charAt(i)-'a';
            if(node.children[a]==null){
                for (int j = 0; j < 26; j++) {
                    TrieNode node1 = node.children[j];
                    if(node1==null||j==a){
                        continue;
                    }
                    for (int k = i+1; k < searchWord.length(); k++) {
                        int index = searchWord.charAt(k)-'a';
                        if(node1.children[index]==null){
                            break;
                        }else {
                            node1 = node1.children[index];
                        }
                    }
                    if(node1.isEnd){
                        return true;
                    }
                }
                return false;
            }else {
                node = node.children[a];
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
//leetcode submit region end(Prohibit modification and deletion)

}