package com.zxq;

import com.zxq.dutychain.factory.DutyChainHandlerFactory;
import com.zxq.dutychain.model.PhoneNumberDTO;
import com.zxq.dutychain.model.SensitiveWordDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;

@SpringBootTest(classes = StatisticsApplication.class)
@RunWith(SpringRunner.class)
public class DutyChainTest {

    @Autowired
    @Qualifier("sensitiveWordChain")
    private DutyChainHandlerFactory sensitiveWordFactory;

    @Autowired
    @Qualifier("phoneNumberChain")
    private DutyChainHandlerFactory phoneNumberFactory;

    @Test
    public void dutyChainTest(){
        sensitiveWordFactory.executeDutyHandler(new SensitiveWordDTO());
        phoneNumberFactory.executeDutyHandler(new PhoneNumberDTO());
    }



}
