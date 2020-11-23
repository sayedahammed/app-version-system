package com.middleware.versioning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("AppVersion")

public class AppVersion implements Serializable {
    private String platform;
    private String force_update;
    private String blacklist;
}
