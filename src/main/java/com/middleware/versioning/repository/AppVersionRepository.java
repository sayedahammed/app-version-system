package com.middleware.versioning.repository;

import com.middleware.versioning.entity.AppVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class AppVersionRepository {

    public static final String HASH_KEY = "AppVersion";

    @Autowired
    public RedisTemplate redisTemplate;

    public AppVersion save(AppVersion version) {
        redisTemplate.opsForHash().put(HASH_KEY, version.getPlatform(), version);
        return version;
    }

    public AppVersion find(String platform) {
        return (AppVersion) redisTemplate.opsForHash().get(HASH_KEY, platform);
    }
}
