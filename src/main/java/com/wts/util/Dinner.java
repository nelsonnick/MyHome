package com.wts.util;

import com.wts.entity.WxService;
import me.chanjar.weixin.cp.bean.WxCpMessage;

public class Dinner implements Runnable {

    public void run() {
        String[] su = new String[5];
        su[0] = "西红柿炒鸡蛋";
        su[1] = "黄瓜炒鸡蛋";
        su[2] = "西葫芦炒鸡蛋";
        su[3] = "韭菜炒鸡蛋";
        su[4] = "豆腐";
        String[] rou = new String[5];
        rou[0] = "西红柿炒鸡蛋";
        rou[1] = "黄瓜炒鸡蛋";
        rou[2] = "西葫芦炒鸡蛋";
        rou[3] = "韭菜炒鸡蛋";
        rou[4] = "豆腐";
        String[] tang = new String[5];
        tang[0] = "西红柿炒鸡蛋";
        tang[1] = "黄瓜炒鸡蛋";
        tang[2] = "西葫芦炒鸡蛋";
        tang[3] = "韭菜炒鸡蛋";
        tang[4] = "豆腐";
        String[] zhu = new String[3];
        zhu[0] = "米饭";
        zhu[1] = "馒头";
        zhu[2] = "饼";
        String food1, food2, food3, food4, food5, food6;
        food1 = su[(int) (Math.random() * su.length)];
        do {
            food2 = su[(int) (Math.random() * su.length)];
        } while (food1.equals(food2));
        food3 = rou[(int) (Math.random() * rou.length)];
        do {
            food4 = rou[(int) (Math.random() * rou.length)];
        } while (food3.equals(food4));
        food5 = tang[(int) (Math.random() * tang.length)];
        food6 = zhu[(int) (Math.random() * zhu.length)];
        StringBuffer food = new StringBuffer();
        food.append("今天的晚餐有：").append("\n");
        food.append("素菜：" + food1).append("\n");
        food.append("素菜：" + food2).append("\n");
        food.append("荤菜：" + food3).append("\n");
        food.append("荤菜：" + food4).append("\n");
        food.append("汤菜：" + food5).append("\n");
        food.append("主食：" + food6);
        WxCpMessage message = WxCpMessage
                .TEXT()
                .agentId(1000002) // 企业号应用ID
                .toUser("@all")
                .content(food.toString())
                .build();
        try {
            WxService.getMe().messageSend(message);
        } catch (Exception e) {

        }
    }
}
