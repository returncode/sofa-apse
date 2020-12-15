package com.returncode.apseboot.prefiled.manager.impl;

import com.returncode.apseboot.prefiled.manager.IPreFiledDemoManager;
import org.springframework.stereotype.Service;

/**
 * @Author: wanglei
 * @Date: 2020/12/14
 */
@Service
public class PreFiledDemoManagerImpl implements IPreFiledDemoManager {

    @Override
    public String doPreFiledMananger(String name) {
        return " PreFileDemo: " + name;
    }
}
