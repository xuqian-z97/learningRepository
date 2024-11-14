package com.zxq.dutychain.handler.handlerParentClass;

/**
 * 责任链父类（抽象类，只需要由子类继承并实现方法）
 * T&E :为使多个领域可以通用，此处对责任链中处理器和处理结果的类型做泛型处理
 */
public abstract class AbstractHandler<T , E> {

    /**
     * 责任链中的下一个处理器
     */
    public AbstractHandler<T , E> nextHandler;

    /**
     * 设置责任链中的下一个处理器
     * @param nextHandler 下一个处理器
     */
    public void setNextHandler(AbstractHandler<T , E> nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 判断是否有下一个处理器
     * @return
     */
    public boolean hasNextHandler() {
        return this.nextHandler != null;
    }


    public E handle(T t) {
        if(hasNextHandler()) {
            //如果还有下一个处理器，那么就交由责任链中的下一个处理器处理
            return nextHandler.handle(t);
        }
        return null;
    }

}
