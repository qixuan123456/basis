package com.qx.shuati.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/10/19
 * Time: 16:11
 */
public class Trie {
    private Trie[] children = new Trie[26];
    private boolean isEnd = false;
    public List<String> list = new ArrayList<>();
    public StringBuilder sb = new StringBuilder();
    public Trie() {
    }

    /**
     *
     * @param string    插入的字符串
     */
    public void insert(String string){
        Trie root = this;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            int index = ch-'a';
            if(root.getChildren()[index]==null){
                root.getChildren()[index] = new Trie();
            }
            root = root.getChildren()[index];
        }
        root.setEnd(true);
    }

    void traverse(Trie root){
        if(root.isEnd){
            list.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if(root.getChildren()[i]!=null){
                sb.append((char)(i+'a'));
                traverse(root.getChildren()[i]);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public Trie[] getChildren() {
        return children;
    }

    public void setChildren(Trie[] children) {
        this.children = children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
