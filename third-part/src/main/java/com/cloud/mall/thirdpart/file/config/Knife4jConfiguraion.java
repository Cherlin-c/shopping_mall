package com.cloud.mall.thirdpart.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * knife4j配置
 *
 * @author : scl
 * @date :  2022/9/4
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguraion {

    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        //指定使用Swagger2规范
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //描述字段支持Markdown语法
                        .description("# 第三方接口 RESTful APIs")
                        .termsOfServiceUrl("http://localhost:88/api/third/")
                        .contact(new Contact("scl", "", ""))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("第三方服务")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.cloud.mall"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}