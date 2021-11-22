package day21.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xuan
 * Date: 2021/11/16
 * Time: 10:31
 */
public class No391 {

    public static void main(String[] args) {
        int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        No391 no391 = new No391();
        System.out.println(no391.isRectangleCover(rectangles));
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int sum = 0;
        int[] max = rectangles[0];
        Map<String,Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            sum += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
            max[0] = Math.min(rectangle[0], max[0]);
            max[1] = Math.min(rectangle[1], max[1]);
            max[2] = Math.max(rectangle[2], max[2]);
            max[3] = Math.max(rectangle[3], max[3]);
            map.put(rectangle[0] + "," + rectangle[1], map.getOrDefault(rectangle[0] + "," + rectangle[1], 0) + 1);
            map.put(rectangle[0] + "," + rectangle[3], map.getOrDefault(rectangle[0] + "," + rectangle[3], 0) + 1);
            map.put(rectangle[2] + "," + rectangle[1], map.getOrDefault(rectangle[2] + "," + rectangle[1], 0) + 1);
            map.put(rectangle[2] + "," + rectangle[3], map.getOrDefault(rectangle[2] + "," + rectangle[3], 0) + 1);
        }
        if(map.getOrDefault(max[0]+","+max[1],0)!=1||map.getOrDefault(max[0]+","+max[3],0)!=1
        ||map.getOrDefault(max[2]+","+max[1],0)!=1||map.getOrDefault(max[2]+","+max[3],0)!=1){
            return false;
        }
        map.remove(max[0]+","+max[1]);
        map.remove(max[0]+","+max[3]);
        map.remove(max[2]+","+max[3]);
        map.remove(max[2]+","+max[1]);

        for (Map.Entry<String ,Integer> a:map.entrySet()) {
            if(a.getValue()!=2&&a.getValue()!=4){
                return false;
            }
        }
        return sum==(max[3]-max[1])*(max[2]-max[0]);
    }
}
