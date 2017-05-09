package com.wts.util;


import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;

public class Service {
    public static WxCpXmlOutMessage getOutMessage(WxCpXmlMessage inMessage) {
        if (inMessage.getMsgType().equals("text")) {
            return WxCpXmlOutMessage
                    .TEXT()
                    .content("您发送了一条文字消息")
                    .fromUser(inMessage.getToUserName())
                    .toUser(inMessage.getFromUserName())
                    .build();
        } else if (inMessage.getMsgType().equals("image")) {
            return WxCpXmlOutMessage
                    .TEXT()
                    .content("您发送了一条图片消息")
                    .fromUser(inMessage.getToUserName())
                    .toUser(inMessage.getFromUserName())
                    .build();
        } else if (inMessage.getMsgType().equals("voice")) {
            return WxCpXmlOutMessage
                    .TEXT()
                    .content("您发送了一条语音消息")
                    .fromUser(inMessage.getToUserName())
                    .toUser(inMessage.getFromUserName())
                    .build();
        } else if (inMessage.getEvent().equals("subscribe")) {
            System.out.println("关注了");
            return null;
        } else if (inMessage.getEvent().equals("unsubscribe")) {
            System.out.println("取消关注了");
            return null;
        } else if (inMessage.getEvent().equals("enter_agent")) {
            System.out.println("进入应用了");
            return null;
        } else  {
            return WxCpXmlOutMessage
                    .TEXT()
                    .content("测试加密消息")
                    .fromUser(inMessage.getToUserName())
                    .toUser(inMessage.getFromUserName())
                    .build();
        }
    }
}
