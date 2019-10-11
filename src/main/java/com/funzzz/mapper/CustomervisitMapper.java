package com.funzzz.mapper;

import com.funzzz.model.Customer;
import com.funzzz.model.Customervisit;
import com.funzzz.model.CustomervisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomervisitMapper {
    int countByExample(CustomervisitExample example);

    int deleteByExample(CustomervisitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Customervisit record);

    int insertSelective(Customervisit record);

    List<Customervisit> selectByExample(CustomervisitExample example);

    Customervisit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customervisit record, @Param("example") CustomervisitExample example);

    int updateByExample(@Param("record") Customervisit record, @Param("example") CustomervisitExample example);

    int updateByPrimaryKeySelective(Customervisit record);

    int updateByPrimaryKey(Customervisit record);
    //外键检测
    int selectForeignKeyByCidForCvs(Integer cid);
    //外键检测
    int selectForeignKeyByCidForCss(Integer empId);
    
    //查询全部访问记里（分页）
    List<Customervisit> selectAllCustomervisit();
  //通过专员名字找到所有访问记录
    List<Customervisit> selectAllCustomervisitByUsername(String username);
}