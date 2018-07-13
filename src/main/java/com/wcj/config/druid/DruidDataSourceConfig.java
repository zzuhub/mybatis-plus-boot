package com.wcj.config.druid;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 
 * <p>Module:DataSourceConfig </p>
 * <p>Description:配置Druid数据源配置类，主要是为了对数据库密码进行加密 </p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ) 15617520389@163.com 
 * @date 2018年4月26日 下午11:26:32
 */
@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class DruidDataSourceConfig {

	private Logger logger=LoggerFactory.getLogger(DruidDataSourceConfig.class);  //日志打印工具
	
	private String type;  //数据源类型
	
	private String url;  //JDBC地址
	
	private String driverClassName;  //驱动程序
	
	private String username; //用户名
	
	private String password; //加密后的密码
	
	private String filters; //过滤器 druid-1.1.6.jar下的过滤器类型文件druid-filter.properties
	
	private String connectionProperties;   //
    
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getConnectionProperties() {
		return connectionProperties;
	}

	public void setConnectionProperties(String connectionProperties) {
		this.connectionProperties = connectionProperties;
	}

	@Bean
	@Primary
	public DataSource druidDataSource(){
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setConnectionProperties(connectionProperties);
		try {
		    dataSource.setFilters(filters);
		} catch (SQLException e) {
		     e.printStackTrace();
		     logger.error("Druid连接池加密过滤器出错:"+e.getMessage());
		}
	    logger.info("Druid连接池初始化完毕......");
	    return dataSource;
	}
	
	
	
}
	
