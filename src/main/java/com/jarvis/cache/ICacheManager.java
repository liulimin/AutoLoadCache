package com.jarvis.cache;

import java.lang.reflect.Type;

import com.jarvis.cache.annotation.Cache;
import com.jarvis.cache.aop.CacheAopProxyChain;
import com.jarvis.cache.to.AutoLoadTO;
import com.jarvis.cache.to.CacheKeyTO;
import com.jarvis.cache.to.CacheWrapper;

/**
 * 缓存管理
 * @author jiayu.qiu
 */
public interface ICacheManager {

    /**
     * 往缓存写数据
     * @param cacheKey 缓存Key
     * @param result 缓存数据
     */
    void setCache(CacheKeyTO cacheKey, CacheWrapper<Object> result);

    /**
     * 根据缓存Key获得缓存中的数据
     * @param key 缓存key
     * @param returnType AOP拦截方法的 GenericReturnType
     * @return 缓存数据
     */
    CacheWrapper<Object> get(CacheKeyTO key, final Type returnType);

    /**
     * 删除缓存
     * @param key 缓存key
     */
    void delete(CacheKeyTO key);

    /**
     * 获取自动加载处理器
     * @return 自动加载处理器
     */
    AutoLoadHandler getAutoLoadHandler();

    /**
     * 销毁：关闭线程
     */
    void destroy();

    /**
     * 加载数据
     * @param pjp CacheAopProxyChain
     * @param autoLoadTO AutoLoadTO
     * @param cacheKey CacheKeyTO
     * @param cache Cache
     * @return Object
     * @throws Throwable 异常
     */
    Object loadData(CacheAopProxyChain pjp, AutoLoadTO autoLoadTO, CacheKeyTO cacheKey, Cache cache) throws Throwable;
}
