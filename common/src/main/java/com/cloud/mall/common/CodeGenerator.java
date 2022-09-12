package com.cloud.mall.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数据库代码生成器
 *
 * @author : scl
 * @date :  2022/9/3
 */
public class CodeGenerator {

    public static void main(String[] args) {
        final String url = "jdbc:mysql://119.91.150.36:3306/cloud_mall?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        final String username = "develop";
        final String password = "de!v@E#l$o%p";
        final String projectPath = System.getProperty("user.dir")+"/common/";
        FastAutoGenerator.create(
                new DataSourceConfig.Builder(url, username, password))
                // 全局配置
                .globalConfig((scanner, builder) -> builder
                        // 设置作者
                        .author(scanner.apply("请输入作者名称？"))
                        // 开启 swagger 模式
                        .enableSwagger()
                        .outputDir(projectPath + "/src/main/java")
                )
                // 包配置
                .packageConfig((scanner, builder) -> builder
                                // 设置父包名com.cloud.mall
//                                .parent(scanner.apply("请输入包名？"))
                                .parent("com.cloud.mall")
                                // 设置父包模块名
                                .moduleName(scanner.apply("模块名"))
//                        .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper/")
                )
                // 策略配置
                .strategyConfig((scanner, builder) -> builder
                        .addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        // 设置过滤表前缀
                        .addTablePrefix(scanner.apply("表前缀:"))
                        .controllerBuilder()
                        //开启生成@RestController控制器
                        .enableRestStyle()
                        //开启驼峰转连字符
                        .enableHyphenStyle()
                        .entityBuilder()
                        .enableLombok()
                        //开启链式模型
                        .enableChainModel()
                        //开启 Boolean 类型字段移除 is 前缀
                        .enableRemoveIsPrefix()
//                        .enableTableFieldAnnotation()
//                        .addTableFills(new Column("create_time", FieldFill.INSERT))
                        .build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(e -> e.controller("/template/controller.java"))
                .execute();


    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }


}