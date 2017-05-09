package com.wts.handler;

import com.wts.entity.WxService;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutTextMessage;


public class TextBuilder {
  public WxCpXmlOutMessage build(String content, WxCpXmlMessage wxMessage,
                                 WxService service)   {
    WxCpXmlOutTextMessage m = WxCpXmlOutMessage.TEXT().content(content)
            .fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName())
            .build();
    return m;
  }
}
