# 责任链设计

> 为完成同一个请求，如果存在多个请求处理器以及未知请求处理器个数或者请求处理器可动态配置的情况下，可以考虑使用责任链模式。

### 本例中涉及的责任链组件

1. 责任链工厂类 `com.zxq.dutychain.factory.DutyChainHandlerFactory`
   - 作用：(1)通过工厂类对外暴露责任链的执行方法 (2)通过工厂类规范了责任链的定义方式
2. 责任链工厂配置类 `com.zxq.dutychain.config.FactoryConfiguration`
   - 作用：通过工厂配置类实现了根据泛形的不同自动装配不同的责任链，避免了多个责任链的互相干扰
3. 责任链处理器抽象类(父类) `com.zxq.dutychain.handler.handlerParentClass.*`
   - 作用：(1)提供了责任链中处理器的处理空方法; (2)提供了发现下一个处理器以及判断是否有下一个处理器的方法，将处理器串联起来;
          (3)为多类型的处理器类型的实现提供了泛形，使得项目中可以根据不同场景通过责任链处理数据的类型不同，构建不同的责任链
4. 责任链处理器实现类(子类) `com.zxq.dutychain.handler.handlerSubClass.*`
   - 作用：实现具体的数据处理逻辑
5. 数据处理类模型 `com.zxq.dutychain.model.*`
   - 封装并传递需要处理的数据

