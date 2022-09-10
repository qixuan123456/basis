package com.qx.zhenti.vivo.xiaozhaoA2020;

/**
 * @author xuan
 * @date 2022/7/7 12:04
 */
import java.io.*;
import java.util.*;

/**
 * Welcome to vivo !
 */

public class No1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);
        System.out.println(output);
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {

        // TODO Write your code here
        int[][][] dp = new int[totalDisk+1][totalMemory+1][services.size()+1];

        for (int i = 1; i < totalDisk + 1; i++) {
            for (int j = 1; j < totalMemory + 1; j++) {
                for (int k = 1; k < services.size() + 1; k++) {
                    Service service = services.get(k-1);
                    dp[i][j][k] = dp[i][j][k-1];
                    if(i>=service.disk&&j>=service.memory){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-service.disk][j-service.memory][k-1]+service.users);
                    }

                }
            }
        }
        return dp[totalDisk][totalMemory][services.size()];
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}
