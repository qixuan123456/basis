package listener;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xuan
 * Date: 2021/12/16
 * Time: 14:38
 */
public class MyEventSource {

    Set<MyListener> eventListeners = new HashSet<>();

    public void addEvenListener(MyListener listener){
        eventListeners.add(listener);
    }

    public boolean removeEventListener(MyListener eventListener) {
        return eventListeners.remove(eventListener);
    }

    public void event1(){
        MyEvent event = new MyEvent(this,MyEvent.EVENT_TYPE_ONE);
        doOnAction(event);
    }

    public void event2(){
        MyEvent event = new MyEvent(this,MyEvent.EVENT_TYPE_TWO);
        doOnAction(event);
    }

    public void event3(){
        MyEvent event = new MyEvent(this,MyEvent.EVENT_TYPE_THREE);
        doOnAction(event);
    }

    public void doOnAction(MyEvent event){
        for (MyListener listener: eventListeners) {
            listener.OnMessage(event);
        }
    }
}
