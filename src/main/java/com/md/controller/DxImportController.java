package com.md.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zyc on 2018/10/10.
 * 短信导入controller
 */
@Controller
@RequestMapping("/dxImport")
public class DxImportController {

    /**
     * 获取需要发送短信的excel页面
     * @return
     */
    @RequestMapping("/importExcel")
    public String importDxExcel() {
        return "dx_import/import";
    }


    /**
     * 发送短信页面
     * @return
     */
    @RequestMapping("/sendSms")
    public String sendSms() {
        return "dx_import/send_sms";
    }

}
