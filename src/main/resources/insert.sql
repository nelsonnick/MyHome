CREATE TABLE `Recipe` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
`name` varchar(255) CHARACTER SET utf8 NULL COMMENT '菜名',
`url` varchar(255) CHARACTER SET utf8 NULL COMMENT '网址',
`type` varchar(255) NULL COMMENT '类型1素菜2荤菜3汤菜4主食5甜点',
`time` varchar(255) NULL COMMENT '使用时间1早餐2午餐3晚餐4加餐',
`season` varchar(255) NULL COMMENT '食用季节1春2夏3秋4冬',
PRIMARY KEY (`id`)
);
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (1, '西红柿炒鸡蛋', 'http://www.meishij.net/zuofa/xihongshichaojidan_21.html', '素菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (2, '西红柿炖牛腩', 'http://www.meishij.net/chufang/diy/jiangchangcaipu/155862.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (3, '凉拌西红柿', 'http://www.meishij.net/zuofa/liangbanxihongshi_13.html', '素菜', '早午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (4, '拌黄瓜', 'http://www.meishij.net/zuofa/banhuanggua_10.html', '素菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (5, '糖醋黄瓜', 'http://www.meishij.net/zuofa/tangcuhuanggua_4.html', '素菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (6, '黄瓜炒肉', 'http://www.meishij.net/zuofa/huangguachaorou_7.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (7, '黄瓜炒虾', 'http://www.meishij.net/zuofa/huangguachaoxia_1.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (8, '黄瓜粉丝', 'http://www.meishij.net/zuofa/huangguafensi.html', '素菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (9, '黄瓜鸡蛋', 'http://www.meishij.net/zuofa/jidanhuanggua_1.html', '素菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (10, '黄瓜肉筒', 'http://www.meishij.net/zuofa/huangguaroutong.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (11, '清炒丝瓜', 'http://www.meishij.net/zuofa/qingchaosigua_11.html', '素菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (12, '丝瓜汤', 'http://www.meishij.net/zuofa/siguatang_12.html', '汤菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (13, '丝瓜肉片', 'http://www.meishij.net/zuofa/roupiansigua_1.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (14, '丝瓜炒蛋', 'http://www.meishij.net/zuofa/siguachaodan_20.html', '素菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (15, '丝瓜酿肉', 'http://www.meishij.net/zuofa/siguaniangrou_5.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (16, '丝瓜花蛤', 'http://www.meishij.net/zuofa/huagesigua.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (17, '蒜香丝瓜', 'http://www.meishij.net/zuofa/suanxiangsigua_7.html', '素菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (18, '丝瓜虾仁', 'http://www.meishij.net/zuofa/siguaxianxia.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (19, '丝瓜蒸肉', 'http://www.meishij.net/zuofa/siguazhengrou.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (20, '金针菇丝瓜', 'http://www.meishij.net/zuofa/jinzhensigua.html', '素菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (21, '肉末丝瓜', 'http://www.meishij.net/zuofa/roumosigua.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (22, '丝瓜油条', 'http://www.meishij.net/zuofa/youtiaosigua.html', '素菜', '早加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (23, '鱼香茄子', 'http://www.meishij.net/zuofa/yuxiangqiezi_95.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (24, '风味茄子', 'http://www.meishij.net/zuofa/fengweiqiezi_1.html', '素菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (25, '麻汁茄子', 'http://www.meishij.net/zuofa/mazhiqiezi.html', '素菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (26, '红烧茄子', 'http://www.meishij.net/zuofa/hongshaoqiezi_29.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (27, '肉末茄子', 'http://www.meishij.net/zuofa/roumoqiezi_29.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (28, '酱香茄子', 'http://www.meishij.net/zuofa/jiangxiangqiezi_8.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (29, '烧茄子', 'http://www.meishij.net/zuofa/shaoqiezi_17.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (30, '茄子烧肉', 'http://www.meishij.net/zuofa/qiezishaorou_6.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (31, '酱茄子', 'http://www.meishij.net/zuofa/jiangqiezi_9.html', '素菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (32, '茄子饼', 'http://www.meishij.net/zuofa/qiezibing_3.html', '荤菜', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (33, '灯笼茄子', 'http://www.meishij.net/zuofa/denglongqiezi.html', '荤菜', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (34, '白米饭', 'http://www.meishij.net/zuofa/mifan_9.html', '主食', '午晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (35, '蛋炒饭', 'http://www.meishij.net/zuofa/danchaomifan.html', '主食', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (36, '香肠炒饭', 'http://www.meishij.net/zuofa/xiangchangchaomifan.html', '主食', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (37, '扬州炒饭', 'http://www.meishij.net/zuofa/yangzhouchaomifan.html', '主食', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (38, '火腿炒饭', 'http://www.meishij.net/zuofa/huotuichaomifan.html', '主食', '早午晚加', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (39, '大米稀饭', '###', '汤菜', '早晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (40, '八宝粥', 'http://www.meishij.net/zuofa/jianbianbabaozhou.html', '汤菜', '早晚', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (41, '煎饼果子', 'http://www.meishij.net/zuofa/jianbingguozi_23.html', '主食', '早', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (42, '肉夹馍', 'http://www.meishij.net/zuofa/roujia_18.html', '主食', '早', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (43, '牛奶', '###', '汤菜', '早', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (44, '酸奶', '###', '汤菜', '早', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (45, '豆腐脑', 'http://www.meishij.net/zuofa/doufunao_13.html', '汤菜', '早', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (46, '油条', 'http://www.meishij.net/zuofa/youtiao_7.html', '主食', '早', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (47, '三明治', 'http://www.meishij.net/zuofa/sanmingzhi_17.html', '主食', '早', '春夏秋冬');
INSERT INTO `recipe` (`id`, `name`, `url`, `type`, `time`, `season`) VALUES (48, '法式小面包', 'http://www.meishij.net/zuofa/fashixiaomianbao_2.html', '甜点', '早加', '春夏秋冬');
