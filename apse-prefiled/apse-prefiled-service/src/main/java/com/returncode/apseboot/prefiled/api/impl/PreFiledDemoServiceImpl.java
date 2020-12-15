package com.returncode.apseboot.prefiled.api.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.returncode.apseboot.prefiled.api.PreFiledDemoService;
import com.returncode.apseboot.prefiled.manager.IPreFiledDemoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SofaService(interfaceType = PreFiledDemoService.class, bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class PreFiledDemoServiceImpl implements PreFiledDemoService {

    @Autowired
    IPreFiledDemoManager preFiledDemoManager;

    @Override
    public String callPreFiled(String name) {
        return preFiledDemoManager.doPreFiledMananger(name);
    }
}
