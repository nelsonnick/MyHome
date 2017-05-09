package com.wts.util;

import com.wts.entity.WxService;
import me.chanjar.weixin.cp.bean.WxCpMessage;

public class Lunch implements Runnable {

    public void run() {
        String[] vegetarian_name = new String[13];
        vegetarian_name[0] = "西红柿炒鸡蛋";
        vegetarian_name[1] = "黄瓜炒鸡蛋";
        vegetarian_name[2] = "西葫芦炒鸡蛋";
        vegetarian_name[3] = "韭菜炒鸡蛋";
        vegetarian_name[4] = "清炒小白菜";
        vegetarian_name[5] = "辣椒炒鸡蛋";
        vegetarian_name[6] = "肉末豆腐";
        vegetarian_name[7] = "葱烧豆腐";
        vegetarian_name[8] = "红烧茄子";
        vegetarian_name[9] = "麻汁茄子";
        String[] vegetarian_url = new String[13];
        vegetarian_url[0] = "http://www.meishij.net/zuofa/xihongshichaojidan_21.html";
        vegetarian_url[1] = "http://www.meishij.net/zuofa/huangguachaojidan_18.html";
        vegetarian_url[2] = "http://www.meishij.net/zuofa/xihuluchaojidan_24.html";
        vegetarian_url[3] = "http://www.meishij.net/chufang/diy/recaipu/19805.html";
        vegetarian_url[4] = "http://www.meishij.net/zuofa/qingchaoxiaobaicai_6.html";
        vegetarian_url[5] = "http://www.meishij.net/zuofa/lajiaochaojidan_16.html";
        vegetarian_url[6] = "http://www.meishij.net/zuofa/roumodoufu_29.html";
        vegetarian_url[7] = "http://www.meishij.net/zuofa/congshaodoufu_1.html";
        vegetarian_url[8] = "http://www.meishij.net/zuofa/hongshaoqiezi_29.html";
        vegetarian_url[9] = "http://www.meishij.net/zuofa/mazhiqiezi.html";

        String[] meat_name = new String[5];
        meat_name[0] = "芸豆肉丝";
        meat_name[1] = "黄瓜虾仁";
        meat_name[2] = "烤鱼排";
        meat_name[3] = "辣椒炒肉";
        meat_name[4] = "炖青鱼";
        String[] meat_url = new String[5];
        meat_url[0] = "http://www.meishij.net/zuofa/rousichaoyundou.html";
        meat_url[1] = "http://www.meishij.net/zuofa/huangguaxiaren.html";
        meat_url[2] = "http://www.meishij.net/zuofa/kaoyupai.html";
        meat_url[3] = "http://www.meishij.net/zuofa/lajiaochaorou_38.html";
        meat_url[4] = "http://www.meishij.net/zuofa/dunqingyu_7.html";

        String[] soup_name = new String[2];
        soup_name[0] = "西红柿鸡蛋汤";
        soup_name[1] = "蘑菇汤";
        String[] soup_url = new String[2];
        soup_url[0] = "http://www.meishij.net/chufang/diy/tangbaocaipu/178125.html";
        soup_url[1] = "http://www.meishij.net/zuofa/mogutang_1.html";

        String[] food = new String[3];
        food[0] = "米饭";
        food[1] = "馒头";
        food[2] = "油饼";

        String food1, food2, food3, food4, food5, food6;
        int number1,number2,number3,number4,number5,number6;
        String url1,url2,url3,url4,url5;
        number1=(int) (Math.random() * vegetarian_name.length);
        food1 = vegetarian_name[number1];
        url1 = vegetarian_url[number1];
        do {
            number2=(int) (Math.random() * vegetarian_name.length);
            food2 = vegetarian_name[number2];
            url2 = vegetarian_url[number2];
        } while (food1.equals(food2));
        number3 = (int) (Math.random() * meat_name.length);
        food3 = meat_name[number3];
        url3= vegetarian_url[number3];
        do {
            number4=(int) (Math.random() * meat_name.length);
            food4 = meat_name[number4];
            url4 = vegetarian_url[number4];
        } while (food3.equals(food4));
        number5 = (int) (Math.random() * soup_name.length);
        food5 = soup_name[number5];
        url5 = vegetarian_url[number5];
        number6 = (int) (Math.random() * food.length);
        food6 = food[number6];

        StringBuffer foods = new StringBuffer();
        foods.append("今天的午餐有：").append("\n");
        foods.append("素菜：<a href=\"" + url1 + "\">"+food1+"</a>").append("\n");
        foods.append("素菜：<a href=\"" + url2 + "\">"+food2+"</a>").append("\n");
        foods.append("荤菜：<a href=\"" + url3 + "\">"+food3+"</a>").append("\n");
        foods.append("荤菜：<a href=\"" + url4 + "\">"+food4+"</a>").append("\n");
        foods.append("汤菜：<a href=\"" + url5 + "\">"+food5+"</a>").append("\n");
        foods.append("主食：" + food6);
        WxCpMessage message = WxCpMessage
                .TEXT()
                .agentId(1000002) // 企业号应用ID
                //.toUser("@all")
                .toUser("WangTianShuo")
                .content(foods.toString())
                .build();
        try {
            WxService.getMe().messageSend(message);
        } catch (Exception e) {

        }
    }
}
