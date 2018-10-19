package com.md.common.util;

import java.net.NetworkInterface;
import java.util.*;

/**
 * Created by zyc on 2018/10/10.
 * 获取电脑硬件信息
 */
public class PCInfoUtil {
    /**
     * 获取MAC地址的方法
     */
    public static List<String> getMACAddress(){
        List<String> macList = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            while (enumeration.hasMoreElements()) {
                StringBuffer stringBuffer = new StringBuffer();
                NetworkInterface networkInterface = enumeration.nextElement();
                if (networkInterface != null) {
                    byte[] bytes = networkInterface.getHardwareAddress();
                    if (bytes != null) {
                        for (int i = 0; i < bytes.length; i++) {
                            if (i != 0) {
                                stringBuffer.append("-");
                            }
                            int tmp = bytes[i] & 0xff; // 字节转换为整数
                            String str = Integer.toHexString(tmp);
                            if (str.length() == 1) {
                                stringBuffer.append("0" + str);
                            } else {
                                stringBuffer.append(str);
                            }
                        }
                        String mac = stringBuffer.toString().toUpperCase();
                        macList.add(mac);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return macList;
    }


}
