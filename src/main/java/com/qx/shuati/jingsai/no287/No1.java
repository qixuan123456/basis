package com.qx.shuati.jingsai.no287;

/**
 * @author Xuan
 * Date: 2022/4/8
 * Time: 19:12
 */
public class No1 {
    public static void main(String[] args) {
        No1 no1 = new No1();
//        System.out.println(no1.timeToInt("02:34"));
        System.out.println(no1.convertTime("00:00", "29:56"));
    }

    public int convertTime(String current, String correct) {
        int difference = timeToInt(correct) - timeToInt(current);
        int res = 0;
        int remainder = difference < 0 ? difference + 1440 : difference;
        res += remainder / 60;
        remainder = remainder % 60;
        res += remainder / 15;
        remainder = remainder % 15;
        res += remainder / 5;
        remainder = remainder % 5;
        res += remainder;
        return res;
    }

    public int timeToInt(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60
                + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }
}
