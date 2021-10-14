package day14;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: xuan
 * Date: 2021/10/14
 * Time: 15:44
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(null);
        queue.add(2);
        while(queue.size()!=0){
            System.out.println(queue.poll());
        }
    }
}
