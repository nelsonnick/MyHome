package com.wts.util;

import com.wts.entity.WxService;
import com.wts.entity.model.Recipe;
import me.chanjar.weixin.cp.bean.WxCpMessage;

import java.util.List;
import java.util.Random;

public class Food {
  public static String getFoodId(String type,String time,String season) {
    List<Recipe> recipes = Recipe.dao.find("SELECT id FROM recipe " +
            "WHERE type LIKE '%"+type+"%' AND time LIKE '%"+time+"%' AND season LIKE '%"+season+"%'");
    return recipes.get(new Random().nextInt(recipes.size())).get("id").toString();
  }
  /**
    两荤两素一汤一主食
   */
  public static String getFood6(String time, String season) {
    Recipe r1,r2,r3,r4,r5,r6;
    String f1, f2, f3, f4, f5, f6;
    r1= Recipe.dao.findById(getFoodId("素",time,season));
    f1 = r1.getName();
    do {
      r2= Recipe.dao.findById(getFoodId("素",time,season));
      f2 = r2.getName();
    } while (f1.equals(f2));

    r3= Recipe.dao.findById(getFoodId("荤",time,season));
    f3 = r3.getName();
    do {
      r4= Recipe.dao.findById(getFoodId("荤",time,season));
      f4 = r4.getName();
    } while (f3.equals(f4));

    r5= Recipe.dao.findById(getFoodId("汤",time,season));
    f5 = r5.getName();


    r6= Recipe.dao.findById(getFoodId("主",time,season));
    f6 = r6.getName();StringBuffer foods = new StringBuffer();

    foods.append(time+"餐推荐：").append("\n");
    foods.append("1：<a href=\"" + r1.getUrl() + "\">"+f1+"</a>").append("\n");
    foods.append("2：<a href=\"" + r2.getUrl() + "\">"+f2+"</a>").append("\n");
    foods.append("3：<a href=\"" + r3.getUrl() + "\">"+f3+"</a>").append("\n");
    foods.append("4：<a href=\"" + r4.getUrl() + "\">"+f4+"</a>").append("\n");
    foods.append("5：<a href=\"" + r5.getUrl() + "\">"+f5+"</a>").append("\n");
    foods.append("6：<a href=\"" + r6.getUrl() + "\">"+f6+"</a>");
    return foods.toString();
  }
  /**
   一荤一素一汤一主食
   */
  public static String getFood4(String type1,String type2,String type3,String type4,String time, String season) {
    Recipe r1,r2,r3,r4;
    r1= Recipe.dao.findById(getFoodId(type1,time,season));
    r2= Recipe.dao.findById(getFoodId(type2,time,season));
    r3= Recipe.dao.findById(getFoodId(type3,time,season));
    r4= Recipe.dao.findById(getFoodId(type4,time,season));
    StringBuffer foods = new StringBuffer();

    foods.append(time+"餐推荐：").append("\n");
    foods.append("1：<a href=\"" + r1.getUrl() + "\">"+r1.getName()+"</a>").append("\n");
    foods.append("2：<a href=\"" + r2.getUrl() + "\">"+r2.getName()+"</a>").append("\n");
    foods.append("3：<a href=\"" + r3.getUrl() + "\">"+r3.getName()+"</a>").append("\n");
    foods.append("4：<a href=\"" + r4.getUrl() + "\">"+r4.getName()+"</a>");
    return foods.toString();
  }

  public static String getFood3(String type1,String type2,String type3,String time, String season) {
    Recipe r1,r2,r3;
    r1= Recipe.dao.findById(getFoodId(type1,time,season));
    r2= Recipe.dao.findById(getFoodId(type2,time,season));
    r3= Recipe.dao.findById(getFoodId(type3,time,season));
    StringBuffer foods = new StringBuffer();

    foods.append(time+"餐推荐：").append("\n");
    foods.append("1：<a href=\"" + r1.getUrl() + "\">"+r1.getName()+"</a>").append("\n");
    foods.append("2：<a href=\"" + r2.getUrl() + "\">"+r2.getName()+"</a>").append("\n");
    foods.append("3：<a href=\"" + r3.getUrl() + "\">"+r3.getName()+"</a>");
    return foods.toString();
  }

  public static String getFood2(String type1,String type2,String time, String season) {
    Recipe r1,r2;
    r1= Recipe.dao.findById(getFoodId(type1,time,season));
    r2= Recipe.dao.findById(getFoodId(type2,time,season));
    StringBuffer foods = new StringBuffer();

    foods.append(time+"推荐：").append("\n");
    foods.append("<a href=\"" + r1.getUrl() + "\">"+r1.getName()+"</a>").append("\n");
    foods.append("<a href=\"" + r2.getUrl() + "\">"+r2.getName()+"</a>");
    return foods.toString();
  }

  public static String getFood(String type,String time, String season) {
    Recipe r = Recipe.dao.findById(getFoodId(type,time,season));
    StringBuffer foods = new StringBuffer();

    foods.append("推荐：").append("\n");
    foods.append("<a href=\"" + r.getUrl() + "\">"+r.getName()+"</a>");
    return foods.toString();
  }

  public static String queryFood(String name) {
    List<Recipe> recipes = Recipe.dao.paginate(1,
            20,
            "SELECT * ",
            "FROM recipe WHERE name LIKE '%"+name+"%'").getList();
    StringBuffer foods = new StringBuffer();
    foods.append("找到如下菜品：").append("\n");
    if (recipes.size()==0){
      return "未找到相应内容，请更换关键词！";
    }else{
      for (int i=0;i<recipes.size();i++){
        foods.append((i+1)+"：<a href=\"" + recipes.get(i).getUrl() + "\">"+recipes.get(i).getName()+"</a>").append("\n");
      }
      return foods.toString();
    }
  }

  public static void sendBreakfast (String season){
    WxCpMessage message = WxCpMessage
            .TEXT()
            .agentId(1000002) // 企业号应用ID
            .toUser("@all")
//            .toUser("WangTianShuo")
            .content(getFood3("汤","主","甜","早",season))
            .build();
    try {
      WxService.getMe().messageSend(message);
    } catch (Exception e) {

    }
  }
  public static void sendLunch (String season){
    WxCpMessage message = WxCpMessage
            .TEXT()
            .agentId(1000002) // 企业号应用ID
            .toUser("@all")
            .content(getFood6("午",season))
            .build();
    try {
      WxService.getMe().messageSend(message);
    } catch (Exception e) {

    }
  }
  public static void sendDinner (String season){
    WxCpMessage message = WxCpMessage
            .TEXT()
            .agentId(1000002) // 企业号应用ID
            .toUser("@all")
            .content(getFood6("晚",season))
            .build();
    try {
      WxService.getMe().messageSend(message);
    } catch (Exception e) {

    }
  }
}
