package com.wts.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.wts.entity.WxService;
import com.wts.entity.model.Recipe;
import com.wts.entity.model.WxService3;
import me.chanjar.weixin.cp.bean.WxCpUser;


public class RecipeController extends Controller {
  /**
   * 页面
   */
  public void index() {
    render("/static/html/recipe.html");
  }

  /**
   * 页面
   */
  public void s() throws Exception{
    String[] res = WxService3.getMe().oauth2getUserInfo(getPara("code"));
    String userId = res[0];
    WxCpUser user = WxService3.getMe().userGet(userId);
    renderText(userId);
  }

  /**
   * 查找
   */
  public void Query() {
    renderJson(Db.paginate(
            getParaToInt("pageCurrent"),
            getParaToInt("pageSize"),
            "SELECT * ",
            "FROM recipe " +
                    "WHERE name LIKE '%" + getPara("keyword") + "%' " +
                    "OR type LIKE '%" + getPara("keyword") + "%' " +
                    "OR season LIKE '%" + getPara("keyword") + "%' " +
                    "OR time LIKE '%" + getPara("keyword") + "%' ORDER BY id DESC").getList());
  }

  /**
   * 计数
   */
  public void Total() {
    Long count = Db.queryLong("SELECT COUNT(*) FROM recipe " +
            "WHERE name LIKE '%" + getPara("keyword") + "%' " +
            "OR type LIKE '%" + getPara("keyword") + "%' " +
            "OR season LIKE '%" + getPara("keyword") + "%' " +
            "OR time LIKE '%" + getPara("keyword") + "%' ");
    renderText(count.toString());
  }

  /**
   * 获取
   */
  public void Get() {
    renderJson(Recipe.dao.findById(getPara("id")));
  }

  /**
   * 删除
   */
  public void Delete() {
    Recipe.dao.deleteById(getPara("id"));
    renderText("OK");

  }

  /**
   * 保存
   */
  public void Save() {
    if (!StrKit.isBlank(getPara("name"))
            && !StrKit.isBlank(getPara("url"))
            && !StrKit.isBlank(getPara("time"))
            && !StrKit.isBlank(getPara("season"))
            && !StrKit.isBlank(getPara("type"))
            ) {
      if (Recipe.dao.find("SELECT id FROM recipe WHERE name = ?", getPara("name").trim()).size() == 0) {
        Recipe object = new Recipe();
        object.set("name", getPara("name"))
                .set("url", getPara("url"))
                .set("time", getPara("time"))
                .set("season", getPara("season"))
                .set("type", getPara("type"))
                .save();
        renderText("OK");
      } else {
        renderText("该菜品已存在！");
      }
    } else {
      renderText("存在未填写的内容");
    }
  }

  /**
   * 修改
   */
  public void Edit() {
    if (!StrKit.isBlank(getPara("name"))
            && !StrKit.isBlank(getPara("url"))
            && !StrKit.isBlank(getPara("time"))
            && !StrKit.isBlank(getPara("season"))
            && !StrKit.isBlank(getPara("type"))
            ) {
      Recipe object = Recipe.dao.findById(getPara("id"));
      if (object != null) {
        if (Recipe.dao.find("SELECT id FROM recipe WHERE name = ?", getPara("name").trim()).size() != 0
                && !object.getStr("name").equals(getPara("name"))) {
          renderText("该菜品已存在！");
        } else {
          object.set("name", getPara("name"))
                  .set("url", getPara("url"))
                  .set("time", getPara("time"))
                  .set("season", getPara("season"))
                  .set("type", getPara("type"))
                  .update();
          renderText("OK");
        }
      } else {
        renderText("指定菜品不存在！");
      }
    } else {
      renderText("存在未填写的内容");
    }
  }


}
