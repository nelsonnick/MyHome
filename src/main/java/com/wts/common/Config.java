package com.wts.common;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.tx.TxByMethods;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.wts.controller.Main;
import com.wts.controller.RecipeController;
import com.wts.entity.model._MappingKit;

/**
 * API引导式配置
 */
public class Config extends JFinalConfig {

    /**
     * 配置常量
     */
    public void configConstant(Constants me) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("a_little_config.txt");
        me.setDevMode(false);
    }

    /**
     * 配置路由
     */
    public void configRoute(Routes me) {
        me.setBaseViewPath("/myhome");
        me.add("/", Main.class);
        me.add("/r", RecipeController.class);
    }

    /**
     * 配置插件
     */
    public void configPlugin(Plugins me) {

        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        me.add(druidPlugin);
        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        _MappingKit.mapping(arp);
        me.add(arp);
        //配置任务调度插件
        Cron4jPlugin cp = new Cron4jPlugin();
//        cp.addTask("0 0 9 * * ? ", new Lunch());
//        cp.addTask("0 0 14 * * ? ", new Dinner());
//        cp.addTask("0 0 20 * * ? ", new Breakfast());
//        cp.addTask("*/1 * * * *", new Lunch());
//        cp.addTask("*/2 * * * *", new Dinner());
        me.add(cp);
;
    }
    public static DruidPlugin createDruidPlugin() {
        return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }
    /**
     * 配置全局拦截器
     */
    public void configInterceptor(Interceptors me) {
        me.add(new TxByMethods("save","update"));
    }

    /**
     * 配置模板
     */
    public void configEngine(Engine me) {
    }
    /**
     * 配置处理器
     * ${contextPath}/dist
     */
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("contextPath"));//设置上下文路径
    }

    /**
     * 建议使用 JFinal 手册推荐的方式启动项目
     * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
     * src/main/webapp 80 / 5
     * WebRoot
     */
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 80, "/");
    }
}
