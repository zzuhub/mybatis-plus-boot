package com.wcj.pojo.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 
 * <p>Module:Employee </p>
 * <p>Description:员工实体 </p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ) 15617520389@163.com 
 * @date 2018年6月30日 下午2:41:13
 */
@TableName("tb_employee")
public class Employee  extends Model<Employee> implements Serializable{

	private static final long serialVersionUID = 7759118994441404838L;
	
	@TableId(type=IdType.AUTO)
	private Integer id; //ID主键
	
	private String lastName; //名称
	
	private String email; //邮箱
	
	private String gender;  //性别
	
	private Integer age;  //年龄

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	protected Serializable pkVal() {
		return this.id ;
	}
	
	
	
	
	
	
	
	

}
