package com.zxq.dutychain.factory;

import cn.hutool.core.lang.Assert;
import com.zxq.dutychain.handler.handlerParentClass.AbstractHandler;

import java.util.List;

public class DutyChainHandlerFactory<T , E> {

    /**
     * 责任链中的第一个处理器
     */
    public AbstractHandler<T , E> firstHandler;

    /**
     * 工厂的构造方法
     * 根据传入的责任链类型，判断应执行的处理器
     * @param handlers 定义好的责任链集合
     */
    public DutyChainHandlerFactory(List<AbstractHandler<T , E>> handlers) {
        Assert.notEmpty(handlers,"无责任链实现类的bean");
        //设置第一个责任链的处理器
        this.firstHandler = handlers.get(0);
        //根据集合中的处理器，按顺序定义责任链
        //通过"最大范围 - 1"防止集合中的最后一个处理器继续设置他的下一个处理器
        for (int i = 0; i < handlers.size() - 1 ; i++) {
            handlers
                    .get(i)
                    .setNextHandler(handlers.get( i + 1 ));
        }
    }

    /**
     * 对外暴露的责任链开始执行的方法
     * @param t 需要通过责任链执行的数据
     * @return
     */
    public E executeDutyHandler(T t){
        return firstHandler.handle(t);
    }

}
