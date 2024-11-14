package com.zxq.aop.jdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理生成工厂类
 */
public class ProxyUtils{

    private User user;

    public ProxyUtils(User user) {
        this.user = user;
    }

    /**
     * 工厂生成代理类的方法
     * @return
     */
    public Object getProxy() {
        //1.获取类加载器
        ClassLoader classLoader = user.getClass().getClassLoader();
        //2.获取被代理类实现的接口
        Class<?>[] interfaces = user.getClass().getInterfaces();
        //3.重写invokeHandler
        InvocationHandler invocationHandler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置通知");
                Object result = method.invoke(user, args);
                System.out.println("后置通知");
                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
