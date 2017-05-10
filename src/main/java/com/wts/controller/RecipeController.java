package com.wts.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.wts.entity.model.Recipe;

public class RecipeController extends Controller {
  /**
   * 页面
   */
  public void index() {
    render("/static/html/recipe.html");
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
                    "OR time LIKE '%" + getPara("keyword") + "%' ").getList());
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
      Recipe object = new Recipe();
      object.set("name", getPara("name"))
              .set("url", getPara("url"))
              .set("time", getPara("time"))
              .set("season", getPara("season"))
              .set("type", getPara("type"))
              .save();
      renderText("OK");
    } else {
      renderText("存在未填写的内容");
    }
  }


  public void getVegetarian() {
    Recipe.dao.find("SELECT * FROM recipe WHERE type='素菜'");
  }
}
