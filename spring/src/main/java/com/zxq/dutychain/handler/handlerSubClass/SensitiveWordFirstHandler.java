package com.zxq.dutychain.handler.handlerSubClass;

import com.zxq.dutychain.handler.handlerParentClass.AbstractHandler;
import com.zxq.dutychain.model.SensitiveWordDTO;
import org.springframework.stereotype.Component;

@Component
//@Order(2)
public class SensitiveWordFirstHandler extends AbstractHandler<SensitiveWordDTO,Boolean> {

    @Override
    public Boolean handle(SensitiveWordDTO sensitiveWordDTO) {
        System.out.println("敏感词责任链----处理器1----已执行！！！");
        return super.handle(sensitiveWordDTO);
    }
}
