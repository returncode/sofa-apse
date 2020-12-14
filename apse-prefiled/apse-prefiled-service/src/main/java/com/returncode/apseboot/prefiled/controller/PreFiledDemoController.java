package com.returncode.apseboot.prefiled.controller;

import com.returncode.apseboot.center.api.HelloSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prefiled")
public class PreFiledDemoController {

    @Autowired
    HelloSyncService helloSyncService;

    @GetMapping
    public String sayHello(String name) {
        return helloSyncService.saySync(name);
    }
}
