package persons.springboot.thread.proxy.demo1_call;

import persons.springboot.thread.proxy.demo1.QqSend;
import persons.springboot.thread.proxy.demo1.Send;
import persons.springboot.thread.proxy.demo1.SendManager;

public class StaticMain {
    public static void main(String[] args) {
        Send send = new QqSend();
        SendManager sendManager = new SendManager(send);
        sendManager.send("接口了第三方扣水电费看论文");
    }
}
