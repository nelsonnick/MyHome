package com.wts.entity;

import com.wts.util.ParamesAPI;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;

public class WxConfig3 extends WxCpInMemoryConfigStorage {
    private volatile static WxConfig3 wxConfig;

    private WxConfig3() {
        this.setCorpId(ParamesAPI.corpId);
        this.setCorpSecret(ParamesAPI.secret3);
        this.setAgentId(1000003);
        this.setToken(ParamesAPI.token);
        this.setAesKey(ParamesAPI.encodingAESKey);
    }

    public static WxConfig3 getMe() {
        if (wxConfig == null) {
            synchronized (WxConfig3.class) {
                if (wxConfig == null) {
                    wxConfig = new WxConfig3();
                }
            }
        }
        return wxConfig;
    }


}