package com.qx.listener;

import java.util.EventObject;
import java.util.Objects;

/**
 * @author Xuan
 * Date: 2021/12/16
 * Time: 13:47
 */
public class MyEvent extends EventObject {

    private static final long serialVersionUID = 6496098798146410884L;

    public static int EVENT_TYPE_ONE = 1;
    public static int EVENT_TYPE_TWO = 2;
    public static int EVENT_TYPE_THREE = 3;

    private int eventType;

    public MyEvent(Object source,int type) {
        super(source);
        this.eventType = type;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEvent myEvent = (MyEvent) o;
        return eventType == myEvent.eventType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType);
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "eventType=" + eventType +
                ", source=" + source +
                '}';
    }
}
