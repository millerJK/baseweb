package com.base.electric.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class CommonCache {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 存放一个数据
     *
     * @param value
     * @param keyOps
     */
    public void saveOneData(Object value, String... keyOps) {
        if (value == null)
            return;

        redisTemplate.opsForValue().set(genKey(keyOps), value);
    }


    public Object getOneData(String... keyOps) {

        return redisTemplate.opsForValue().get(getOneData(keyOps));
    }


    public <T> T getOneData(Class<T> tClass, String... keyOps) {
        Object oneData = getOneData(keyOps);
        if (oneData == null)
            return null;

    }


    /**
     * 生成key的规则
     * <p>
     * eg: usercache_dahuang_123456
     *
     * @param keyOps
     * @return
     */
    private String genKey(String... keyOps) {
        StringBuilder builder = new StringBuilder(this.getClass().getSimpleName());
        for (String keyOpt : keyOps) {
            builder.append("_");
            builder.append(keyOpt);
        }
        return builder.toString();
    }
}
