package com.funzzz.mapper;

import com.funzzz.model.Customershare;
import com.funzzz.model.CustomershareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomershareMapper {
   
	int countByExample(CustomershareExample example);

    int deleteByExample(CustomershareExample example);

    int deleteByPrimaryKey(Integer id);
    //通过cid和emp_id删除
    int deleteCustomershareByCidAndEmpId(Customershare customershare);
    //通过cid和emp_id查id
    int selectByPrimaryKeyByCidAndEmpId(Customershare customershare);
    //外键检测
    int selectForeignKeyByCid(Integer cid);
    //外键检测
    int selectForeignKeyByEmpId(Integer empId);
    
    
    int insert(Customershare record);

    int insertSelective(Customershare record);

    List<Customershare> selectByExample(CustomershareExample example);

    Customershare selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customershare record, @Param("example") CustomershareExample example);

    int updateByExample(@Param("record") Customershare record, @Param("example") CustomershareExample example);

    int updateByPrimaryKeySelective(Customershare record);

    int updateByPrimaryKey(Customershare record);
    
    int insertMoreData(List<Customershare> list);
    
    int updateMoreData(List<Customershare> list);
    
    List<Customershare>  selectAll();
    
}