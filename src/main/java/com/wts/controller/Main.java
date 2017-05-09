package com.wts.controller;

import com.jfinal.core.Controller;
import com.wts.entity.WxService;
import com.wts.handler.MsgHandler;
import com.wts.util.ParamesAPI;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;
import me.chanjar.weixin.cp.api.WxCpMessageRouter;
import me.chanjar.weixin.cp.bean.WxCpMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.util.crypto.WxCpCryptUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class Main extends Controller {
  private MsgHandler msgHandler;
  public void index() throws Exception{
    renderText("11");
  }
  public void callBack() throws IOException {
    WxCpInMemoryConfigStorage config = new WxCpInMemoryConfigStorage();
    config.setCorpId(ParamesAPI.corpId);
    config.setCorpSecret(ParamesAPI.secret);
    config.setAgentId(1000002);
    config.setToken(ParamesAPI.token);
    config.setAesKey(ParamesAPI.encodingAESKey);

    WxCpMessageRouter router = new WxCpMessageRouter(WxService.getMe());
    router.rule().content("哈哈")
            .msgType(WxConsts.XML_MSG_TEXT)
            .handler(msgHandler)
            .end();

    if (getRequest().getMethod() == "GET") {
      System.out.println("11111");
      PrintWriter out = this.getResponse().getWriter();
      String result;
      if (!WxService.getMe().checkSignature(getPara("msg_signature"), getPara("timestamp"), getPara("nonce"), getPara("echostr"))) {
        result = "";
      } else {
        WxCpCryptUtil cryptUtil = new WxCpCryptUtil(config);
        result = cryptUtil.decrypt(getPara("echostr"));
      }
      out.print(result);
      out.close();
    } else if (getRequest().getMethod() == "POST") {
      this.getRequest().setCharacterEncoding("UTF-8");
      this.getResponse().setCharacterEncoding("UTF-8");
      InputStream inputStream = this.getRequest().getInputStream();
      WxCpXmlMessage inMessage = WxCpXmlMessage.fromEncryptedXml(inputStream, config, getPara("timestamp"), getPara("nonce"), getPara("msg_signature"));
      System.out.println(inMessage);
      WxCpXmlOutMessage outMessage = router.route(inMessage);




      if (outMessage != null) {
        this.getResponse().getWriter().write(outMessage.toEncryptedXml(config));
      }
    } else {

    }
  }
}
