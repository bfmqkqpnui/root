package persons.springboot.thread.proxy.demo1_call;

import persons.springboot.thread.proxy.demo1.EmailSend;
import persons.springboot.thread.proxy.demo1.QqSend;
import persons.springboot.thread.proxy.demo1.Send;
import persons.springboot.thread.proxy.demo1.SendManager;
import persons.springboot.thread.proxy.demo1_proxy_impl.SendHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //邮件发送
        Send send = new EmailSend();
        SendManager sendManager = new SendManager(send);
        InvocationHandler handler = new SendHandler(send);
        Class<?> cls = send.getClass();
        /**
         *loader 类加载器
         *interfaces 实现接口
         *handler InvocationHandler
         */
        Send emailSend = (Send) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        emailSend.send("测试邮件发送内容");
        //QQ发送
        send = new QqSend();
        handler = new SendHandler(send);
        cls = send.getClass();

        Send qqSend = (Send) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        qqSend.send("hello World!!!");
    }
}
