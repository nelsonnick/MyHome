package com.wts.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.wts.entity.model.Course;
import com.wts.entity.model.Teacher;
import com.wts.interceptor.OverdueCheck;
import com.wts.interceptor.PageCheck;
import com.wts.interceptor.PermissionCheck;
import com.wts.util.ExportUtil;
import com.wts.validator.*;
import com.wts.validator.course.Course_Edit;
import com.wts.validator.course.Course_Exist;
import com.wts.validator.course.Course_Save;

import java.io.IOException;

import static com.wts.util.Util.PermissionString;


public class Recipe extends Controller {
  /**
   * 页面
   */
  public void Page() {
    render("/static/html/desktop/Teacher/Desktop_Teacher_Course.html");
  }


  /**
   * 查找
   */
  public void Query() {
    renderJson(Db.paginate(
            getParaToInt("pageCurrent"),
            getParaToInt("pageSize"),
            "SELECT *, " +
                    "(case type when 1 then '必修课' when 2 then '选修课' else '错误' end ) as tname, " +
                    "(case state when 1 then '可用' when 2 then '停用' else '错误' end ) as sname ",
            "FROM course WHERE del = 0 AND (name LIKE '%" + getPara("keyword") + "%' " +
                    "OR detail LIKE '%" + getPara("keyword") + "%') ORDER BY id ASC").getList());
  }

  /**
   * 计数
   */
  public void Total() {
    Long count = Db.queryLong("SELECT COUNT(*) FROM course WHERE del = 0 AND (name LIKE '%" + getPara("keyword") + "%' OR detail LIKE '%" + getPara("keyword") + "%')");
    renderText(count.toString());
  }


  /**
   * 删除
   */
  public void Delete() {
    renderText("OK");

  }

  /**
   * 保存
   */
  public void Save() {
    Course object = new Course();
    object.set("name", getPara("name"))
            .set("url", getPara("url"))
            .set("amount", getPara("amount"))
            .set("type", getPara("type"))
            .set("state", getPara("state"))
            .set("del", 0)
            .save();
    renderText("OK");
  }


}
