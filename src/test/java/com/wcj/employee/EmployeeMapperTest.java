package com.wcj.employee;

import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wcj.base.BaseUnit;
import com.wcj.mapper.EmployeeMapper;
import com.wcj.pojo.po.Employee;
/**
 * 
 * <p>Module:EmployeeMapperTest </p>
 * <p>Description: 员工单元测试</p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ) 15617520389@163.com 
 * @date 2018年6月30日 下午2:58:08
 */
public class EmployeeMapperTest extends BaseUnit{

	@Resource
    private DataSource ds;
	
	@Resource
	private EmployeeMapper employeeMapper;
	
	@Test
	public void testDataSource()throws Exception{
		Connection connection = ds.getConnection();
		logger.info("连接成功，连接池信息："+connection);
		logger.info("EmployeeMapper信息："+employeeMapper);
	}
	
	@Test
    public void testSelect()throws Exception{
		Employee emp = employeeMapper.selectById(1);
		logger.info("查询ID为1的员工："+emp);
	}
	
	
	@Test
	public void testInsert()throws Exception{
		  //设置全列字段
		  Employee employeeAllCol = new Employee();
		  employeeAllCol.setAge(18);
		  employeeAllCol.setEmail("15617520389@163.com");
		  employeeAllCol.setGender("女");
		  employeeAllCol.setLastName("因为我是婉瑜呀@");
		  Integer insert = employeeMapper.insert(employeeAllCol);
		  logger.warn("全列字段增加状态："+insert);
		  
		  //设置部分字段
		  Employee employeeNotAllCol = new Employee();
		  employeeNotAllCol.setLastName("我是宁哥，我的秘密");
		  insert=employeeMapper.insert(employeeNotAllCol);
		  logger.warn("部分列列字段增加状态："+insert);
		  
		  
	}
	
	
	@Test
	public void testInsertAllCol()throws Exception{
		  //设置全字段
		  Employee employeeAllCol = new Employee();
		  employeeAllCol.setAge(38);
		  employeeAllCol.setEmail("2827724252@qq.com");
		  employeeAllCol.setGender("女");
		  employeeAllCol.setLastName("摩登兄弟");
		  Integer insertAllCol = employeeMapper.insertAllColumn(employeeAllCol);
		  logger.warn("属性全部非空时执行InsetAllClum方法效果："+insertAllCol);
		  
		  
		  //设置部分字段
		  Employee employeeNotAllCol = new Employee();
		  employeeNotAllCol.setEmail("mial.163.com");
		  insertAllCol = employeeMapper.insertAllColumn(employeeNotAllCol);
		  logger.warn("属性部分为空时执行InsetAllClum方法效果："+insertAllCol);
		
	}
	
	@Test
	public void testUpdate()throws Exception{
		   Employee employeeUpdateByID = new Employee();
		   employeeUpdateByID.setId(10);
		   employeeUpdateByID.setLastName("网红泡面");
		   employeeMapper.updateById(employeeUpdateByID);
		   logger.warn("更新操作UpdateById:"+employeeUpdateByID);
		   
		   Employee employeeUpdateAllColByID = new Employee();
		   employeeUpdateAllColByID.setAge(16);
		   employeeUpdateAllColByID.setEmail("zzu@edu.cn");
		   employeeUpdateAllColByID.setId(11);
		   employeeMapper.updateAllColumnById(employeeUpdateAllColByID);
		   logger.warn("更新操作UpdateAllColumnById:"+employeeUpdateAllColByID);
		   
		   
	}
	
	
	@Test
	public void testSelectByID()throws Exception{
		  Employee selectById = employeeMapper.selectById(8);
		  logger.warn("根据ID查询，查询ID【"+8+"】："+selectById);
	}
	
	
	@Test
	public void testSelectOne()throws Exception{
		Employee entity=new Employee();
		entity.setAge(35);
		Employee selectOne = employeeMapper.selectOne(entity);
		logger.warn("selectOne操作："+selectOne);
	}
	
	@Test
	public void testSelectByBatchIds()throws Exception{
		List<Employee> list = employeeMapper.selectBatchIds(Arrays.asList(1,3,5,7,9,11));
		logger.warn("SelectByBatchIds操作："+list.size());
		list = employeeMapper.selectBatchIds(Arrays.asList(99));
		logger.warn("SelectByBatchIds操作："+list.size());
	}
	
	@Test
	public void testSelectByMap()throws Exception{
		Map<String, Object> columnMap=new HashMap<>();
		columnMap.put("id", "11");
		columnMap.put("age", 16);
		List<Employee> results = employeeMapper.selectByMap(columnMap);
		logger.warn("根据ID=11并且age=18进行查询："+results);
	}
	
	
	@Test
	public void testSelectPage()throws Exception{
		String email="%@atguigu.com";
		
		Wrapper<Employee> wrapper=new Wrapper<Employee>() {
			
			private static final long serialVersionUID = -823222248366646170L;

			@Override
			public String getSqlSegment() {
				StringBuilder sqlBuilder = new StringBuilder("  ");
				sqlBuilder.append(" where ")
				          .append(" email like ")
				          .append("'")
				          .append(email)
				          .append("'");
				logger.warn("拼接查询sql语句："+sqlBuilder);
				return sqlBuilder.toString();
			}
		};
		RowBounds rowBounds=new RowBounds(0, 10);
		List<Employee> list = employeeMapper.selectPage(rowBounds, wrapper);
		logger.warn("查询结果："+list.size());
	}
	
	
	@Test
	public void testDeleteByID()throws Exception{
		  Integer deleteById = employeeMapper.deleteById(11);
		  logger.warn("删除数据【id=11】结果："+deleteById);
	}
	
	
	@Test
	public void testDeleteByBatchIds()throws Exception{
		Integer deleteBatchIds = employeeMapper.deleteBatchIds(Arrays.asList(11,12,13));
		logger.warn("删除数据量："+deleteBatchIds);
	}
	
	@Test
	public void testDeleteByMap()throws Exception{
		Map<String, Object> columnMap=new HashMap<>();
		columnMap.put("last_name", "因为我是婉瑜呀@");
		Integer deleteByMap = employeeMapper.deleteByMap(columnMap);
		logger.warn("删除数据【last_name=因为我是婉瑜呀@】结果："+deleteByMap);
	}
	
	@Test
	public void testSelectPageByEW()throws Exception{
		   List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(0, 10),
				                       new EntityWrapper<Employee>()
				                           .eq("email", "2827724252@qq.com2")
				                           .between("age", 24, 40)
				   );
		   logger.warn("查询结果："+emps.size());
	}
	
	@Test
	public void testSelectByWrapper()throws Exception{
		   List<Employee> emps = employeeMapper.selectList(new Wrapper<Employee>() {

			private static final long serialVersionUID = 9176408975388524274L;

			@Override
			public String getSqlSegment() {
				return " where last_name='网红泡面' ";
			}
			
		  });
		   
		   logger.warn("查询结果："+emps.size());
		   
	} 
	
	
	@Test
	public void testUpdateByEW()throws Exception{
		Wrapper<Employee> wrapper=new Wrapper<Employee>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public String getSqlSegment() {
				return " where id=10 ";
			}
		};
		Employee entity= new Employee();
		entity.setEmail("15617520389@163.com");
		Integer update = employeeMapper.update(entity, wrapper);
		logger.warn("更新数据量："+update);
		
	}
	
	@Test
	public void testDeleteByEW()throws Exception{
		  Wrapper<Employee> wrapper=new Wrapper<Employee>() {
			
			private static final long serialVersionUID = -4380683525327867793L;

			@Override
			public String getSqlSegment() {
				return " where id <= 1 ";
			}
			
			
		};
		Integer delete = employeeMapper.delete(wrapper);
		logger.warn("删除数据量："+delete);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSelectByCondition()throws Exception{
		  List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(1, 10), 
										                    Condition.create()
										                             .eq("last_name", "我是宁哥，我的秘密")
										                             .ge("age", 24)
				                               );
		  logger.warn("查询数据量："+emps.size());
	}
	
	@Test
	public void testInsertByAR()throws Exception{
		  Employee employee = new Employee();
		  employee.setAge(18);
		  employee.setEmail("wangchengjian@zzu.edu.cn");
		  employee.setGender("男");
		  boolean insert = employee.insert();
		  logger.warn("数据增加状况："+insert);
	}
	
	@Test
	public void testDeleteByAR()throws Exception{
		 Employee employee = new Employee();
		 boolean deleted = employee.deleteById(1);
		 logger.warn("根据ID删除数据："+deleted);
	}
	
	@Test
	public void testUpdateByAR()throws Exception{
		 Employee employee = new Employee();
		 employee.setEmail("wcj@zzu.edu.cn");
		 employee.setId(10);
		 boolean update = employee.updateById();
		 logger.warn("更新数据量："+update);
		 
	}
	
	@Test
	public void testSelectByAR()throws Exception{
		Employee employee = new Employee();
		List<Employee> emps = employee.selectAll();
		logger.warn("查询全部数据量："+emps.size());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
