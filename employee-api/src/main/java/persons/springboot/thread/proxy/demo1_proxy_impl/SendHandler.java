package persons.springboot.thread.proxy.demo1_proxy_impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理 需要实现 InvocationHandler接口
 * 事务处理器
 */
public class SendHandler implements InvocationHandler {

    private Object object;//要代理的对象

    public SendHandler(Object object) {
        super();
        this.object = object;
    }

    /**
     * 参数：
     * proxy 被代理的对象
     * method 被代理对象的方法
     * args 方法的参数
     * 返回：
     * Object 方法返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        method.invoke(object, args);
        doAfter();
        return null;
    }

    private void doBefore() {
        System.out.println("动态代理方法调用之前");
    }

    private void doAfter() {
        System.out.println("动态代理方法调用之后");
    }
}
