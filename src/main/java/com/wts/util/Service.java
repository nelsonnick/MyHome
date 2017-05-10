package com.wts.util;


import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;

import static com.wts.util.Food.*;

public class Service {
    public static WxCpXmlOutMessage getOutMessage(WxCpXmlMessage inMessage) {
        if (inMessage.getMsgType().equals("text")) {
            return WxCpXmlOutMessage
                    .TEXT()
                    .content(queryFood(inMessage.getContent()))
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
        } else if (inMessage.getEvent().equals("click")) {
            if(inMessage.getEventKey().equals("A1")){
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood3("汤","主","甜","早",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else if (inMessage.getEventKey().equals("A2")) {
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood6("午",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else if (inMessage.getEventKey().equals("A3")) {
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood6("晚",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else if (inMessage.getEventKey().equals("A4")) {
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood2("素","甜","加",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else if (inMessage.getEventKey().equals("B1")) {
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood("素","",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else if (inMessage.getEventKey().equals("B2")) {
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood("荤","",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else if (inMessage.getEventKey().equals("B3")) {
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood("汤","",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else if (inMessage.getEventKey().equals("B4")) {
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood("主","",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else if (inMessage.getEventKey().equals("B5")) {
                return WxCpXmlOutMessage
                        .TEXT()
                        .content(getFood("甜","",""))
                        .fromUser(inMessage.getToUserName())
                        .toUser(inMessage.getFromUserName())
                        .build();
            }else{
                System.out.println("点击了按钮");
            }
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
