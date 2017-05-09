package com.wts.entity;

import com.wts.util.ParamesAPI;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;

public class WxConfig extends WxCpInMemoryConfigStorage {
    private volatile static WxConfig wxConfig;

    private WxConfig() {
        this.setCorpId(ParamesAPI.corpId);
        this.setCorpSecret(ParamesAPI.secret);
        this.setAgentId(1000002);
        this.setToken(ParamesAPI.token);
        this.setAesKey(ParamesAPI.encodingAESKey);
    }

    public static WxConfig getMe() {
        if (wxConfig == null) {
            synchronized (WxConfig.class) {
                if (wxConfig == null) {
                    wxConfig = new WxConfig();
                }
            }
        }
        return wxConfig;
    }


}