package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/7/31 16:12
 */
public class No208 {

    public static void main(String[] args) {
        System.out.println(Math.round(-1.5));
        System.out.println(Math.round(-1.4));
        System.out.println(Math.round(-1.6));

        System.out.println(Math.round(1.4));
        System.out.println(Math.round(1.5));
        System.out.println(Math.round(1.6));
    }
    static class Trie {
        Node root =  new Node();
        public Trie() {

        }
        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length() ; i++) {
                int id = word.charAt(i)-'a';
                if(node.child[id]==null){
                    node.child[id] = new Node();
                }
                node = node.child[id];
                if(i==word.length()-1){
                    node.end = true;
                }
            }


        }

        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length() ; i++) {
                int id = word.charAt(i)-'a';
                if(node.child[id]==null){
                    return false;
                }
                node = node.child[id];
                if(i==word.length()-1&&node.end){
                    return true;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length() ; i++) {
                int id = prefix.charAt(i)-'a';
                if(node.child[id]==null){
                    return false;
                }
                node = node.child[id];
                if(i==prefix.length()-1){
                    return true;
                }
            }
            return false;
        }

        static class Node{
            Node[] child  = new Node[26];
            boolean end = false;
        }
    }
}
