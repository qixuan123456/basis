////在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如
//，词
////根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。 
////
//// 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如
//果继
////承词有许多可以形成它的词根，则用最短的词根替换它。 
////
//// 你需要输出替换之后的句子。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by 
////the battery"
////输出："the cat was rat by the bat"
//// 
////
//// 示例 2： 
////
//// 
////输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
////输出："a a b c"
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= dictionary.length <= 1000 
//// 1 <= dictionary[i].length <= 100 
//// dictionary[i] 仅由小写字母组成。 
//// 1 <= sentence.length <= 10^6 
//// sentence 仅由小写字母和空格组成。 
//// sentence 中单词的总量在范围 [1, 1000] 内。 
//// sentence 中每个单词的长度在范围 [1, 1000] 内。 
//// sentence 中单词之间由一个空格隔开。 
//// sentence 没有前导或尾随空格。 
//// 
////
//// 
//// Related Topics 字典树 数组 哈希表 字符串 👍 196 👎 0
//

package leetcode.editor.cn;

import java.util.*;
/**
  * 题目Id：648; 
  * 题目：单词替换，replace-words; 
  * 日期：2022-07-07 10:34:42
*/

public class No648_ReplaceWords{
    public static void main(String[] args) {
        Solution solution = new No648_ReplaceWords().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for (String s : dictionary) {
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            int j = 1;
            for (; j <= strings[i].length(); j++) {
                String temp = strings[i].substring(0,j);
                if(set.contains(temp)){
                    if(sb.length()>0){
                        sb.append(" ");
                    }
                    sb.append(temp);
                    break;
                }
            }
            if(j>strings[i].length()){
                if(sb.length()>0){
                    sb.append(" ");
                }
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}