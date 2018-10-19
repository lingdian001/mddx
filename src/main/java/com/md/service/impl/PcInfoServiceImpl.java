package com.md.service.impl;

import com.md.common.config.MddxConfig;
import com.md.common.util.MD5Util;
import com.md.common.util.PCInfoUtil;
import com.md.service.IPcInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zyc on 2018/10/16.
 */
@Service
public class PcInfoServiceImpl implements IPcInfoService {
    @Autowired
    private MddxConfig mddxConfig;

    public static boolean isLicense=false;

    /**
     * 获取本机license 是否有效
     * @return
     */
    public  boolean isLicense(){
        List<String> macList= PCInfoUtil.getMACAddress();
        for(String mac : macList){
            if(mddxConfig.getLicense().equals(MD5Util.MD5(mac))){
                isLicense=true;
                return true;
            }
        }
        return false;
    };
}
