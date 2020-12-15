package com.returncode.apseboot.center.manager.impl;

import com.returncode.apseboot.center.entity.pojo.CenterDemoDO;
import com.returncode.apseboot.center.manager.ICenterDemoManager;
import com.returncode.apseboot.common.exception.NullResultException;
import org.springframework.stereotype.Service;

/**
 * @Author: wanglei
 * @Date: 2020/12/15
 */
@Service
public class CenterDemoManagerImpl implements ICenterDemoManager {
    @Override
    public CenterDemoDO doCenterDemoManager(String code) {
        CenterDemoDO center = new CenterDemoDO();
        center.setUnId(100010101L);
        center.setCode(code);
        if ("500".equals(code)) {
            throw new NullResultException();
        }
        return center;
    }
}
