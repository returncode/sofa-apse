package com.returncode.common.utils;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BeanUtil extends BeanUtils {

    /**
     * 拷贝数据
     *
     * @param dest 目标数据
     * @param orig 源数据
     */
    public static void beanCopy(final Object dest, final Object orig) {
        try {
            copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static <T> T beanCopy(Object source, Class<T> targetType) {
        String sourceJson = JSON.toJSONString(source);
        return JSON.parseObject(sourceJson, targetType);
    }

    public static <T> List<T> beanCopyList(List<?> sourceList, Class<T> targetType) {
        String sourceListJson = JSON.toJSONString(sourceList);
        return JSON.parseArray(sourceListJson, targetType);
    }

}
