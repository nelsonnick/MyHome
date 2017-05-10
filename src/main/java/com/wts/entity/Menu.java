package com.wts.entity;


import com.wts.util.ParamesAPI;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;
import me.chanjar.weixin.cp.api.WxCpServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Menu {

  public static void main(String[] args) {

    List<WxMenuButton> buttons = new ArrayList<WxMenuButton>();
    WxMenuButton button1 = new WxMenuButton();
    button1.setName("推荐早餐");
    button1.setType("click");
    button1.setKey("1");
    WxMenuButton button2 = new WxMenuButton();
    button2.setName("推荐午餐");
    button2.setKey("2");
    button2.setType("click");
    WxMenuButton button3 = new WxMenuButton();
    button3.setName("推荐晚餐");
    button3.setKey("1");
    button3.setType("click");
    buttons.add(button1);
    buttons.add(button2);
    buttons.add(button3);
    WxMenu wxMenu = new WxMenu();
    wxMenu.setButtons(buttons);

    WxCpInMemoryConfigStorage config = new WxCpInMemoryConfigStorage();
    config.setCorpId(ParamesAPI.corpId);
    config.setCorpSecret(ParamesAPI.secret);
    config.setAgentId(1000002);
    config.setToken(ParamesAPI.token);
    config.setAesKey(ParamesAPI.encodingAESKey);

    WxCpServiceImpl wxCpService = new WxCpServiceImpl();
    wxCpService.setWxCpConfigStorage(config);
    try {
      wxCpService.menuCreate(wxMenu);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
