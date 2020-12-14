package com.returncode.apseboot.center.controller;

import com.returncode.apseboot.prefiled.api.PreFiledDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class CenterDemoController {

    @Autowired
    PreFiledDemoService preFiledDemoService;

    @GetMapping
    public String doCenter(String name) {
        return preFiledDemoService.callPreFiled(name);
    }

}
