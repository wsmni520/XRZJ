package com.xrzj.decoration.api.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据请求中对cache进行管理
 */

public class CacheManager {

    private static Map<String, CacheObject> cacheMap = new HashMap<>();

    /**
     * 添加到cache
     *
     * @param key
     * @param data
     * @param period
     */
    public static void addData(String key, Object data, int period) {
        CacheObject cacheObject = getData(key);
        if (cacheObject != null) {
            /**
             * 如果类型不同，便重新加入到缓存中
             */
            if (period != cacheObject.getPeriod()) {
                cacheObject.setPeriod(period);
                /**
                 * 移除老的value
                 */
                removeInvalidData(key);
                /**
                 * 重新putvalue
                 */
                cacheMap.put(key, cacheObject);
            }
        } else {
            cacheObject = new CacheObject(data, period);
            cacheMap.put(key, cacheObject);
        }
    }

    /**
     * 获取cache
     *
     * @param key
     * @return
     */
    public static CacheObject getData(String key) {
        CacheObject cacheObject = cacheMap.get(key);
        if (cacheObject != null) {
            /**
             * 判断缓存是否过期
             */
            if (cacheObject.isValid()) {
                return cacheObject;
            } else {
                removeInvalidData(key);
            }
        }
        return null;
    }

    /**
     * 移除过期的key
     *
     * @param key
     */
    public static void removeInvalidData(String key) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
        }
    }
}
