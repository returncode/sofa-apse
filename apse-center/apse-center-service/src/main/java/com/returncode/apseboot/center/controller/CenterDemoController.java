package com.returncode.apseboot.center.controller;

import com.returncode.apseboot.center.entity.pojo.CenterDemoDO;
import com.returncode.apseboot.center.entity.vo.CenterDemoVO;
import com.returncode.apseboot.center.manager.ICenterDemoManager;
import com.returncode.apseboot.common.utils.BeanUtil;
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
    @Autowired
    ICenterDemoManager centerDemoManager;

    @GetMapping
    public CenterDemoVO doCenter(String code) {
        CenterDemoDO centerDemoDO = centerDemoManager.doCenterDemoManager(code);
        CenterDemoVO centerDemoVO = BeanUtil.beanCopy(centerDemoDO, CenterDemoVO.class);
        centerDemoVO.setName(preFiledDemoService.callPreFiled(code));
        return centerDemoVO;
    }

}
