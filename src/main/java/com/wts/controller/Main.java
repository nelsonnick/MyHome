package com.wts.controller;

import com.jfinal.core.Controller;
import com.wts.entity.WxConfig;
import com.wts.entity.WxService;
import me.chanjar.weixin.cp.api.WxCpMessageRouter;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.util.crypto.WxCpCryptUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import static com.wts.util.Service.getOutMessage;

public class Main extends Controller {

    public void callBack() throws IOException {

        if (getRequest().getMethod() == "GET") {
            PrintWriter out = this.getResponse().getWriter();
            String result;
            if (!WxService.getMe().checkSignature(getPara("msg_signature"), getPara("timestamp"), getPara("nonce"), getPara("echostr"))) {
                result = "";
            } else {
                WxCpCryptUtil cryptUtil = new WxCpCryptUtil(WxConfig.getMe());
                result = cryptUtil.decrypt(getPara("echostr"));
            }
            out.print(result);
            out.close();
        } else if (getRequest().getMethod() == "POST") {
            this.getRequest().setCharacterEncoding("UTF-8");
            this.getResponse().setCharacterEncoding("UTF-8");
            InputStream inputStream = this.getRequest().getInputStream();
            WxCpXmlMessage inMessage = WxCpXmlMessage.fromEncryptedXml(inputStream, WxConfig.getMe(), getPara("timestamp"), getPara("nonce"), getPara("msg_signature"));
            if (getOutMessage(inMessage) != null) {
                this.getResponse().getWriter().write(getOutMessage(inMessage).toEncryptedXml(WxConfig.getMe()));
            }
        } else {
            System.out.println("错误请求");
        }
    }
}
