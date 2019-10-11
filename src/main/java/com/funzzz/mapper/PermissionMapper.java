package com.funzzz.mapper;

import com.funzzz.model.Permission;
import com.funzzz.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer permissionid);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer permissionid);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    //to==
    List<Permission> selectPermissionByParentId(Integer parebtId);
    //
    List<String> selectPermissionByUserName(String username);
    //
    List<Permission> selectAllPermissions();
    //
    List<Permission> selectAllMeuns();
    
}