package com.wcj.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcj.mapper.EmployeeMapper;
import com.wcj.pojo.po.Employee;
/**
 * 
 * <p>Module:EmpController </p>
 * <p>Description:员工控制器 </p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ) 15617520389@163.com 
 * @date 2018年7月15日 上午1:13:40
 */
@RequestMapping("/Emp")
@RestController
public class EmpController {
	
	@Resource
	private EmployeeMapper employeeMapper;

	@GetMapping("/say/{msg}")
	public String sya(@PathVariable String msg) {
		  return "<h1>ECHO程序【"+msg+"】</h1>";
	}
	
	@GetMapping("/getEmp/{id}")
	public Employee getEmp(@PathVariable Integer id) {
		Employee employee = employeeMapper.selectById(id);
		return employee;
	}
	
	
	
	
	
}
