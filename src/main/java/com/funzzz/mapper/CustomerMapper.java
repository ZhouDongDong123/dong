package com.funzzz.mapper;

import com.funzzz.model.Customer;
import com.funzzz.model.CustomerExample;
import com.funzzz.model.Employees;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    //查找所有顾客信息 包括专员名字（所以在顾客bean中加一个专员名属性）
    List<Customer> selectAllCustomer();
    
    //一个顾客可能对应多个专员
    List<Employees> selectEmployeesByCid(Integer cid);
    
    //通过id得到名字
    String selectCusNameById(Integer cid);
    Integer selectCusIdByName(String cusName);
    
    //通过专员名字找到所有顾客
    List<Customer> selectAllCustomerByUsername(String username);
}