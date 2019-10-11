package com.funzzz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.funzzz.model.Customer;
import com.funzzz.model.Employees;
import com.funzzz.model.EmployeesExample;

public interface EmployeesMapper {
    int countByExample(EmployeesExample example);

    int deleteByExample(EmployeesExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employees record);

    int insertSelective(Employees record);
    //获取所有员工用于分页 会被插件拦截的
    List<Employees> selectAllEmployee();
  //获取所有员工不包括经理用于分页 会被插件拦截的
    List<Employees> selectAllEmployeeNotManager();
    //那条件查询所有数据分页
    List<Employees> selectAllEmployeeByCondition(String condition);
    
    
    List<Employees> selectByExample(EmployeesExample example);
    
    Employees selectByPrimaryKey(Integer empId);
    List<Employees> selectEmployeesByPrimaryKey(Integer empId);
    
    
    Employees selectEmployeeForLogin(Employees emp);
 
    int updateByExampleSelective(@Param("record") Employees record, @Param("example") EmployeesExample example);

    int updateByExample(@Param("record") Employees record, @Param("example") EmployeesExample example);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
    String selectPasswordByUserName(String username);
    //通过id得到名字
    String selectUserNameById(Integer emp_id);
    //通过id得到名字
    Integer selectEmpIdByUsername(String username);
  //通过名字修改密码
    int updatePasswordByUsername(Employees  employee);
    //一个专员可能对应多个顾客
    List<Customer> selectCustomerByEmpId(Integer empId);
    // 重命名检测
    Integer selectCountByUsername(String username);
    

}