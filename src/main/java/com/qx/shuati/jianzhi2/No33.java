package com.qx.shuati.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/1 15:30
 */
public class No33 {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);
    }

    public boolean verify(int[] postorder,int left,int right){
        if(left>=right){
            return true;
        }
        int t = postorder[right];
        int mid = left;
        for (int i = left; i < right; i++) {
            if(postorder[i]<t){
                mid++;
            }else {
                break;
            }
        }
        for (int i = mid; i < right; i++) {
            if(postorder[i]<=t){
                return false;
            }
        }
        return verify(postorder,left,mid-1)&&verify(postorder,mid,right-1);
    }
}
