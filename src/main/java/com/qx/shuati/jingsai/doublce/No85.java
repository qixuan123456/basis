package com.qx.shuati.jingsai.doublce;

import com.qx.algorithm.SegmentTreeDynamic;

/**
 * @author xuan
 * @date 2022/8/21 12:50
 */
public class No85 {

    public int minimumRecolors(String blocks, int k) {
        int ans = 0;
        int sums = 0;
        for (int i = 0; i < k; i++) {
            if(blocks.charAt(i)=='W'){
                sums++;
            }
        }
        ans = sums;
        for (int i = 1; i <= blocks.length()-k; i++) {
            if(blocks.charAt(i-1)=='W'){
                sums--;
            }
            if(blocks.charAt(i+k-1)=='W'){
                sums++;
            }
            ans = Math.min(sums,ans);
        }
        return ans;

    }

    public int secondsToRemoveOccurrences(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        while (true){
            boolean flag = true;
            for (int i = 0; i < chars.length-1; i++) {
                if(chars[i]=='0'&&chars[i+1]=='1'){
                    chars[i] = '1';
                    chars[i+1] = '0';
                    i++;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
            ans++;
        }
        return ans;
    }


    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        for (int i = 0; i < shifts.length; i++) {
            update(root,1,n+1,shifts[i][0]+1,shifts[i][1]+1,shifts[i][2]==1?1:-1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int index = query(root,1,n+1,i+1,i+1)%26;
            chars[i] = (char)(chars[i]+index);
            if(chars[i]<'a'){
                chars[i] = (char)(chars[i]+26);
            }
            if(chars[i]>'z'){
                chars[i] = (char) (chars[i]-26);
            }
        }
        return new String(chars);
    }





    static class Node {
        Node left, right;
        int val, add;
    }
    private int N = (int) 1e9;
    private Node root = new Node();

    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += (end - start + 1) * val;
            node.add += val;
            return ;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }
    public int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) return node.val;
        int mid = (start + end) >> 1, ans = 0;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) ans += query(node.left, start, mid, l, r);
        if (r > mid) ans += query(node.right, mid + 1, end, l, r);
        return ans;
    }
    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }
    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return ;
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

}
