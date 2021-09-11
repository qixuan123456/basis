package day21.leetcode;

public class No1828 {
    public static void main(String[] args) {
       int[][] points = {{1,1},{2,2},{3,3},{4,4},{5,5}};
       int[][] queries = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
        int[] answer = countPoints(points,queries);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0;i<points.length;i++){
            for(int j=0;j<queries.length;j++){
                if(Math.pow(points[i][0]-queries[j][0],2)+Math.pow(points[i][1]-queries[j][1],2)<=Math.pow(queries[j][2],2)){
                    answer[j]++;
                }
            }
        }
        return answer;
    }
}
