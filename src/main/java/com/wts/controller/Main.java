package com.wts.controller;

import com.jfinal.core.Controller;
import com.wts.entity.WxConfig;
import com.wts.entity.WxService;
import com.wts.png.PNGLoader;
import com.wts.png.getPNG;
import me.chanjar.weixin.cp.bean.WxCpMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.util.crypto.WxCpCryptUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import static com.wts.util.Service.getOutMessage;

public class Main extends Controller {
  public void index() throws IOException {

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
    renderNull();
  }

  public void png() throws Exception {
    System.out.println("开始：");
    Thread.sleep(5000);
    for (int i = 0; i < 100000; i++) {
      getPNG a = new getPNG("d:\\a", "png");//
      a.snapShot();
      System.out.println("a结束");
      Thread.sleep(10000);
      getPNG b = new getPNG("d:\\b", "png");//
      b.snapShot();
      System.out.println("b结束");
      Integer v = PNGLoader.compareImage("D:\\a.png", "D:\\b.png");
      try {
        if (v < 95) {
          WxCpMessage message = WxCpMessage
                  .TEXT()
                  .agentId(1000002) // 企业号应用ID
                  .toUser("WangTianShuo")
                  .content("视频正在播放")
                  .build();
          WxService.getMe().messageSend(message);
        } else {
          WxCpMessage message = WxCpMessage
                  .TEXT()
                  .agentId(1000002) // 企业号应用ID
                  .toUser("WangTianShuo")
                  .content("视频已暂停")
                  .build();
          WxService.getMe().messageSend(message);
        }
      } catch (Exception e) {

      }
      File file1 = new File("a.png");
      file1.delete();
      File file2 = new File("b.png");
      file2.delete();
    }

  }
}
