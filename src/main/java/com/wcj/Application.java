package com.wcj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 
 * <p>Module:Application </p>
 * <p>Description:SpringBoot集成MyBatis-Plus、PageHelper程序启动类 </p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ) 15617520389@163.com 
 * @date 2018年4月6日 下午1:39:36
 */
@EnableTransactionManagement
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner {
	
    private Logger logger = LoggerFactory.getLogger(Application.class);  //日志工具

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("SpringBoot+MyBatis-Plus整合开发");
        logger.info("服务启动完成!");
    }

}
