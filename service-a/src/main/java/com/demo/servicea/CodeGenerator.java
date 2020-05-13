//package com.demo.servicea;
//
//
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//import java.util.Scanner;
//
///**
// * @author Cenyol mail: mr.cenyol@gmail.com
// * @date 2019-09-23 15:28
// */
//@Slf4j
//public class CodeGenerator {
//
//    //包名
//    public static final String PACKAGE_NAME = "com.demo.servicea";
//
//    //模块名
//    public static final String MODULE_NAME = "";
//
//    //数据库名
//    public static final String DB_NAME = "demo";
//
//    //数据库表
//    public static final String TABLE_NAME = "test_a";
//
//    //获取当前项目的路径
////    public static final String PROJECT_PATH = System.getProperty("user.dir");
//
//    public static final String PROJECT_PATH = "D://ideaWork/cloud-demo/service-a/";
//    //代码存储路径
//    public static final String CODE_SAVE_PATH =  "D://ideaWork/cloud-demo/service-a/src/main/java/" + StringUtils.join((PACKAGE_NAME + "." + MODULE_NAME).split("\\."), "/");
//
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//
//        gc.setOutputDir(PROJECT_PATH + "/src/main/java");
//        gc.setAuthor("Jingran.Zhang");
//        gc.setOpen(false);
//        gc.setFileOverride(true);
//        gc.setServiceName("%sService");
//        gc.setBaseColumnList(true);
//        gc.setBaseResultMap(true);
//        gc.setDateType(DateType.ONLY_DATE);
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://192.168.56.102:3306/" + DB_NAME + "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("demo");
//        dsc.setPassword("123456");
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(MODULE_NAME);
//        pc.setParent(PACKAGE_NAME);
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return PROJECT_PATH + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//
//        focList.add(new FileOutConfig("/templates/service.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return CODE_SAVE_PATH + "/service/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
//            }
//        });
//
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
////        strategy.setTablePrefix(new String[]{"test_"});
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
////        strategy.setSuperEntityClass("com.demo.servicea.bean.BaseEntity");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
////        strategy.setSuperControllerClass("com.demo.servicea.controller.BaseController");
//        strategy.setInclude(TABLE_NAME);
//
//
//        //自定义基础的Entity类，公共字段 ，填入将在entity中不出现
//
////        strategy.setSuperEntityColumns("id");
//        strategy.setControllerMappingHyphenStyle(true);
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//        //删除自己不需要的目录
////        deleteDir(new File(CODE_SAVE_PATH+"/service/impl"));
//    }
//
//
//
//
//    private static void deleteDir(File dir) {
//        if (dir.isDirectory()) {
//            File[] files = dir.listFiles();
//            for (int i = 0; i < files.length; i++) {
//                deleteDir(files[i]);
//            }
//        }
//        dir.delete();
//    }
//}