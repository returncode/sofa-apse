package com.returncode.apseboot.common.utils;

import java.util.UUID;

/**
 * UUID工具类
 *
 */
public final class UuidUtil {

    private UuidUtil(){
        throw new RuntimeException("UuidUtil.class can't be instantiated");
    }

    /**
     * 获取随机的UUID小写字符串
     */
    private static String getRandomUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toLowerCase();
    }

    /**
     * 从UUID字符串中去除“-”分隔符
     */
    private static String removeSeparatorFromUuid(String uuid) {
        uuid = uuid.replaceAll("-","");
        return uuid;
    }

    /**
     * 获取小写32位唯一unid
     */
    public static String getUnid() {
        String uuid = getRandomUuid();
        return removeSeparatorFromUuid(uuid);
    }

}
