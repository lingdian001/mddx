package com.md.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zyc on 2018/10/10.
 * 页面跳转
 */

@Controller
public class WebConctroller {
    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 错误页面
     * @return
     */
    @RequestMapping("/errora")
    public String errorb() {
        return "errora";
    }





}
