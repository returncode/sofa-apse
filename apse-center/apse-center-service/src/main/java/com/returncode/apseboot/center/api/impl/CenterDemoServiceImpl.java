package com.returncode.apseboot.center.api.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.returncode.apseboot.center.api.CenterDemoService;
import com.returncode.apseboot.center.entity.CenterDemoDTO;
import com.returncode.apseboot.center.entity.pojo.CenterDemoDO;
import com.returncode.apseboot.center.manager.ICenterDemoManager;
import com.returncode.apseboot.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SofaService(interfaceType = CenterDemoService.class, bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class CenterDemoServiceImpl implements CenterDemoService {

    @Autowired
    ICenterDemoManager centerDemoManager;

    @Override
    public CenterDemoDTO doCenterDemo(String code) {
        CenterDemoDO centerDemoDO = centerDemoManager.doCenterDemoManager(code);
        CenterDemoDTO centerDemoDTO = BeanUtil.beanCopy(centerDemoDO, CenterDemoDTO.class);
        return centerDemoDTO;
    }
}
