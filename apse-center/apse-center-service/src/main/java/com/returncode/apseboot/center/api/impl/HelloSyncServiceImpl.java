package com.returncode.apseboot.center.api.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.returncode.apseboot.center.api.HelloSyncService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@SofaService(interfaceType = HelloSyncService.class, bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class HelloSyncServiceImpl implements HelloSyncService {

    @Override
    public String saySync(String string) {
        return "hello " + string;
    }

    @Override
    public String saySync(String string,String city) {
        if ("123".equals(string)) {
            throw new RuntimeException("业务错误");
        }
        if(!ObjectUtils.isEmpty(city)){
            return "hello " + string+" from "+city;
        }
        return "hello " + string;
    }

    @Override
    public int sayCount(String name) {
        return name.length();
    }
}
