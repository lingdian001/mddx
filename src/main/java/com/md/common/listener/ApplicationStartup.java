package com.md.common.listener;

import com.md.service.IPcInfoService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by zyc on 2018/10/16.
 * 系统初始化
 */
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        IPcInfoService service = contextRefreshedEvent.getApplicationContext().getBean(IPcInfoService.class);
        service.isLicense();
    }

}
