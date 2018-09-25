package com.boot.security.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Druid数据源配置
 *
 * @author hebh
 *
 */
@Component
public class StaticConfig {
    @Value("${druid.md5key}")
    public String md5key;

}
