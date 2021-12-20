package listener;

/**
 * @author Xuan
 * Date: 2021/12/16
 * Time: 16:14
 *
 * 匿名内部类实现
 */


public class Test2 {

    public static void main(String[] args) {
        MyEventSource eventSource = new MyEventSource();

        eventSource.addEvenListener(new OuterListener());
        eventSource.addEvenListener(new MyListener() {
            @Override
            public void OnMessage(MyEvent event) {
                if(event.getEventType()==2){
                    System.out.println("深入理解计算机系统");
                }
            }
        });
        eventSource.event1();
        eventSource.event2();
        eventSource.event3();
    }
}
