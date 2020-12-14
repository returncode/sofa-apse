package com.returncode.apseboot.open.controller;

import com.returncode.apseboot.open.manager.IApiOpenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    IApiOpenManager apiOpenManager;

    @GetMapping
    public String getName(String name) {
        return apiOpenManager.doHelloSync(name);
    }

}
