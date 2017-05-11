package com.wts.entity.model;

import com.wts.entity.WxConfig3;
import me.chanjar.weixin.cp.api.WxCpServiceImpl;

public class WxService3 extends WxCpServiceImpl{
  private volatile static WxService3 wxService;

  private WxService3() {
    this.setWxCpConfigStorage(WxConfig3.getMe());
  }

  public static WxService3 getMe() {
    if (wxService == null) {
      synchronized (WxService3.class) {
        if (wxService == null) {
          wxService = new WxService3();
        }
      }
    }
    return wxService;
  }


}