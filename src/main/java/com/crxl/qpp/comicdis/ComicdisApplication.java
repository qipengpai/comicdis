package com.crxl.qpp.comicdis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.crxl.qpp.comicdis.basics.dao")
@EnableScheduling
public class ComicdisApplication  extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ComicdisApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(ComicdisApplication.class);
	}
}
/*
@SpringBootApplication：这是一个组合注解，聚合了多个注解的功能，包含：排除自启动项、排除自启动项的beanname、扫描包和扫描类。【建议瞜一眼源码更好】

@EnableAutoConfiguration：这个注解是用来启动springboot中的自动配置项目，必须的加上，否则无法正常使用springboot默认配置的配置项目。

@ComponentScan ：扫描controller层和service层中所有类上的注解(这个注解可以不加，因为组合注解@SpringBootApplication已经可以扫描)。

@MapperScan("com.zxz.mapper") ：管理mybatis中所有mapper接口的代理对象。

@EnableTransactionManagement(proxyTargetClass = true)：开启事务管理的注解。
@ServletComponentScan 设置启动时spring能够扫描到我们自己编写的servlet和filter, 用于Druid监控
*/