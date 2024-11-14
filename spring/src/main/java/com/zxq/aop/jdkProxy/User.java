package com.zxq.aop.jdkProxy;

public class User implements Person{

    private String name;

    private String age;

    @Override
    public void sayHello() {
        System.out.println(name + " say hello: 他" + age + "岁了");
    }

    @Override
    public void sleep() {
        System.out.println(name + " 要睡觉了 ");
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public User setAge(String age) {
        this.age = age;
        return this;
    }
}
