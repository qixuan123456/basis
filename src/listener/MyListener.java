package listener;

import java.util.EventListener;

/**
 * @author Xuan
 * Date: 2021/12/16
 * Time: 13:43
 */
interface MyListener extends EventListener {
    void OnMessage(MyEvent event);
}

