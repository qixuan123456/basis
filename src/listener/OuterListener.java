package listener;

/**
 * @author Xuan
 * Date: 2021/12/16
 * Time: 15:52
 */
public class OuterListener implements MyListener{
    @Override
    public void OnMessage(MyEvent event) {
        MyEventSource eventSource = (MyEventSource) event.getSource();
        System.out.println("监听事件类型为："+String.valueOf(event.getEventType()));
    }
}
