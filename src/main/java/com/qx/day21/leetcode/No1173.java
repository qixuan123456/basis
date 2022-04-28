package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No1173 {
    
    public static void main(String[] args) {
        int index=0;
        int i=0;

        String ruleKey="type";
        String ruleValue = "phone";
        List<List<String>> item = new ArrayList<>();
        String[][] items = {{"phone", "blue", "pixel"}, {"computer", "silver", "phone"},{"phone", "gold", "iphone"}};


        for(int j=0;j<3;j++){
            List<String > s =new ArrayList<>();
            for (int k=0;k<3;k++){
                s.add(items[j][k]);
            }
            item.add(s);

        }

        if("type".equals(ruleKey))
        {
            index=0;
        }
        else if("color".equals(ruleKey)){
            index=1;
        }
        else if("name".equals(ruleKey)){
            index=2;
        }
        for (List<String> a:
        item){
            if(a.get(index)==ruleValue){
                i++;
            }
        }
        System.out.println(i);
    }
}
