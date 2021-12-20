package listener;


/**
 * @author Xuan
 * Date: 2021/12/16
 * Time: 13:51
 *
 * 外部类实现  OuterListener
 */
public class Test1 {

    public static void main(String[] args) {
        MyEventSource eventSource = new MyEventSource();
        eventSource.addEvenListener(new OuterListener());
        eventSource.event1();
        eventSource.event2();
        eventSource.event3();

    }
}
