package com.wcj.config.mp;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

/**
 * 
 * <p>Module:MybatisPlusConfig </p>
 * <p>Description:MyBatis-Plus配置 </p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ) 15617520389@163.com 
 * @date 2018年6月30日 下午2:29:58
 */
@Configuration
public class MybatisPlusConfig {

	  /**
	    * 
	   * @Title: paginationInterceptor
	   * @Description: 配置分页插件
	   * @param @return    
	   * @return PaginationInterceptor   
	   * @throws
	    */
	   @Bean
	   public PaginationInterceptor paginationInterceptor() {
	      return new PaginationInterceptor();
	   }
	   
	   /**
	    * 
	   * @Title: mapperScannerConfigurer
	   * @Description: 配置扫描Java的Mapper文件
	   * @param @return    
	   * @return MapperScannerConfigurer   
	   * @throws
	    */
	    @Bean
	    public MapperScannerConfigurer mapperScannerConfigurer() {
	        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
	        scannerConfigurer.setBasePackage("com.wcj.mapper");
	        return scannerConfigurer;
	    }
	    
	    /**
	     * SQL执行效率插件
	     */
	    @Bean
	    @Profile({"dev","test"})// 设置 dev test 环境开启
	    public PerformanceInterceptor performanceInterceptor() {
	        return new PerformanceInterceptor();
	    }
	    
	    
	
}
