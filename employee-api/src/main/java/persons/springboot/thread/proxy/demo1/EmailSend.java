package persons.springboot.thread.proxy.demo1;

public class EmailSend implements Send {

    @Override
    public void send(String content) {
        System.out.println("email 发送的内容是[" + content + "]");
    }
}
