package com.zxq.dutychain.config;

import com.zxq.dutychain.factory.DutyChainHandlerFactory;
import com.zxq.dutychain.handler.handlerParentClass.AbstractHandler;
import com.zxq.dutychain.model.PhoneNumberDTO;
import com.zxq.dutychain.model.SensitiveWordDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FactoryConfiguration {

    /**
     * 注入敏感词校验责任链
     * @param handlerList
     * @return
     */
    @Bean("sensitiveWordChain")
    public DutyChainHandlerFactory sensitiveWordDutyChainHandlerFactory(List<AbstractHandler<SensitiveWordDTO,Boolean>> handlerList) {
        DutyChainHandlerFactory<SensitiveWordDTO,Boolean> dutyChain = new DutyChainHandlerFactory<>(handlerList);
        return dutyChain;
    }

    /**
     * 注入电话号码校验责任链
     * @param handlerList
     * @return
     */
    @Bean("phoneNumberChain")
    public DutyChainHandlerFactory phoneNumberDutyChainHandlerFactory(List<AbstractHandler<PhoneNumberDTO,Boolean>> handlerList) {
        DutyChainHandlerFactory<PhoneNumberDTO,Boolean> dutyChain = new DutyChainHandlerFactory<>(handlerList);
        return dutyChain;
    }

}
