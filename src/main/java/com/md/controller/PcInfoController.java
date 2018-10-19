package com.md.controller;

import com.md.common.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyc on 2018/10/10.
 * 授权controller
 */
@Controller
@RequestMapping("/pcinfo")
public class PcInfoController {

    /**
     * 授权页面
     * @return
     */
    @RequestMapping("/license")
    public String license() {
        return "license/license";
    }

    @PostMapping("/getLicense")
    @ResponseBody
    public Map<String,String> getLicense(@RequestParam("mac") String mac) {
        Map<String,String> map = new HashMap<String,String>();
        String license =MD5Util.MD5("mddx@"+mac);
        map.put("license",license);
        return map;
    }


}
