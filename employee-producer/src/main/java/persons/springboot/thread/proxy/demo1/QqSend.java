package persons.springboot.thread.proxy.demo1;

public class QqSend implements Send {
    @Override
    public void send(String content) {
        System.out.println("QQ发送的消息是[" + content + "]");
    }
}
