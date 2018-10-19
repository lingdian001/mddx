package com.md.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by zyc on 2018/10/17.
 * 系统自定义properties 文件
 */

@Component
@ConfigurationProperties(prefix = "mddx")
@PropertySource("classpath:/mddx.properties")
public class MddxConfig {

    private String license;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
