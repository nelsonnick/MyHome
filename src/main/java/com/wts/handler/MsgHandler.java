package com.wts.handler;

import com.wts.entity.WxService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.cp.api.WxCpMessageHandler;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;

import java.util.Map;


public class MsgHandler implements WxCpMessageHandler {

  public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage,
                                  Map<String, Object> context, WxCpService wxCpService,
                                  WxSessionManager sessionManager) {
    WxService wxService = (WxService) wxCpService;
    if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
      //TODO 可以选择将消息保存到本地
    }
    //TODO 组装回复消息
    String content = "回复信息内容";
    return new TextBuilder().build(content, wxMessage, wxService);

  }
}
