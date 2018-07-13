package com.wcj.base;



import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * 
 * <p>Module:BaseUnit </p>
 * <p>Description:单元测试父类 </p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ) 15617520389@163.com 
 * @date 2018年4月5日 下午4:55:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseUnit {
	
	protected Logger logger = LoggerFactory.getLogger(BaseUnit.class);  //日志工具
	
}
