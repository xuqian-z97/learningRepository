package com.zxq.aop.jdkProxy;

public class Demo {

    public static void main(String[] args) {
        User user = new User();
        user.setName("zxq");
        user.setAge("18");
        ProxyUtils proxyUtils = new ProxyUtils(user);
        Person proxy = (Person) proxyUtils.getProxy();
        proxy.sayHello();
        proxy.sleep();

    }

}
