package persons.springboot.thread.proxy.demo1;

public class SendManager implements Send {
    private Send send;

    public SendManager(Send send) {
        this.send = send;
    }

    public SendManager() {
        this.send = new EmailSend();
    }

    @Override
    public void send(String content) {
        send.send(content);
    }
}
