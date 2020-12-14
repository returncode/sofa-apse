package com.returncode.apseboot.prefiled.api.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.returncode.apseboot.prefiled.api.PreFiledDemoService;
import org.springframework.stereotype.Service;

@Service
@SofaService(interfaceType = PreFiledDemoService.class, bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class PreFiledDemoServiceImpl implements PreFiledDemoService {

    @Override
    public String callPreFiled(String name) {
        throw new RuntimeException("业务异常");
//        return " callPreFiled " + name;
    }
}
