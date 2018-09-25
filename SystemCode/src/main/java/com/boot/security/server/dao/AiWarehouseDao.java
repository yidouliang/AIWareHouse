package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiWarehouse;

@Mapper
public interface AiWarehouseDao {

    @Select("select * from ai_warehouse t where t.id = #{id}")
    AiWarehouse getById(Long id);

    @Delete("delete from ai_warehouse where id = #{id}")
    int delete(Long id);

    int update(AiWarehouse aiWarehouse);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_warehouse(ID, NAME, ADDESS, LONGITUDE, LATITUDE, TYPE, USER_ID, WAREHOUSE_STATE, EXT1, EXT2, EXT3) values(#{ID}, #{NAME}, #{ADDESS}, #{LONGITUDE}, #{LATITUDE}, #{TYPE}, #{USERID}, #{WAREHOUSESTATE}, #{EXT1}, #{EXT2}, #{EXT3})")
    int save(AiWarehouse aiWarehouse);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiWarehouse> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
