package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Resourceproduct;

@Mapper
public interface ResourceproductDao {

    @Select("select * from resourceproduct t where t.id = #{id}")
    Resourceproduct getById(Long id);

    @Delete("delete from resourceproduct where id = #{id}")
    int delete(Long id);

    int update(Resourceproduct resourceproduct);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into resourceproduct(productname, totalnum, remainnum, creator, creattime, updatetime, price, originprice, discount, region, remark, userid, ext1, ext2, ext3) values(#{productname}, #{totalnum}, #{remainnum}, #{creator}, #{creattime}, #{updatetime}, #{price}, #{originprice}, #{discount}, #{region}, #{remark}, #{userid}, #{ext1}, #{ext2}, #{ext3})")
    int save(Resourceproduct resourceproduct);
    
    int count(@Param("params") Map<String, Object> params);

    List<Resourceproduct> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
