package com.zxq.dutychain.handler.handlerSubClass;

import com.zxq.dutychain.handler.handlerParentClass.AbstractHandler;
import com.zxq.dutychain.model.PhoneNumberDTO;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberHandler extends AbstractHandler<PhoneNumberDTO,Boolean> {

    @Override
    public Boolean handle(PhoneNumberDTO phoneNumberDTO) {
        System.out.println("电话校验责任链----处理器1----已执行！");
        return super.handle(phoneNumberDTO);
    }
}
