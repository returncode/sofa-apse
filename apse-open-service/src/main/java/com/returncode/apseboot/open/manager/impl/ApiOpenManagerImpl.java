package com.returncode.apseboot.open.manager.impl;

import com.returncode.apseboot.center.api.HelloSyncService;
import com.returncode.apseboot.open.manager.IApiOpenManager;
import com.returncode.apseboot.prefiled.api.PreFiledDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiOpenManagerImpl implements IApiOpenManager {

    @Autowired
    HelloSyncService helloSyncService;
    @Autowired
    PreFiledDemoService preFiledDemoService;

    @Override
    public String doHelloSync(String name) {
        return helloSyncService.saySync(name, "zhengzhou") + preFiledDemoService.callPreFiled(name);
    }
}
