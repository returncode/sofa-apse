package com.returncode.apseboot.center.api;

/**
 * 测试服务
 */
public interface HelloSyncService {

    String saySync(String string);

    String saySync(String string,String city);

    int sayCount(String name);

}
