package com.wcj.pojo.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.wcj.pojo.po.Employee;
/**
 * 
 * <p>Module:EmployeeVO </p>
 * <p>Description:员工VO </p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ) 15617520389@163.com 
 * @date 2018年6月30日 下午2:52:50
 */
public class EmployeeVO extends Employee {

	private static final long serialVersionUID = -1009169218374427376L;

	/*需要被忽略的字段*/
	@TableField(strategy=FieldStrategy.IGNORED)  
	private String queryKeyWord; //查询关键字

	public String getQueryKeyWord() {
		return queryKeyWord;
	}

	public void setQueryKeyWord(String queryKeyWord) {
		this.queryKeyWord = queryKeyWord;
	}
	
	
	
	
}
