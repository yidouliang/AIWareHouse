package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiOrderThirdLevel;

@Mapper
public interface AiOrderThirdLevelDao {

    @Select("select * from ai_order_third_level t where t.id = #{id}")
    AiOrderThirdLevel getById(Long id);

    @Delete("delete from ai_order_third_level where id = #{id}")
    int delete(Long id);

    int update(AiOrderThirdLevel aiOrderThirdLevel);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_order_third_level(firstlevelid, mktinvid, usercode, telephone, serialnumber, boxname, boxtype, pserialnumber, productprice, producttypeid, productname, productcode, productimgurl, productdesc, buynum, activityid, activityname, datastate, ext1, ext2, ext3, ext4) values(#{firstlevelid}, #{mktinvid}, #{usercode}, #{telephone}, #{serialnumber}, #{boxname}, #{boxtype}, #{pserialnumber}, #{productprice}, #{producttypeid}, #{productname}, #{productcode}, #{productimgurl}, #{productdesc}, #{buynum}, #{activityid}, #{activityname}, #{datastate}, #{ext1}, #{ext2}, #{ext3}, #{ext4})")
    int save(AiOrderThirdLevel aiOrderThirdLevel);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiOrderThirdLevel> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
