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
    @Insert("insert into ai_order_third_level(ID, FIRST_LEVEL_ID, MKT_INV_ID, USER_CODE, TELEPHONE, SERIAL_NUMBER, boxName, boxType, P_SERIAL_NUMBER, PRODUCT_PRICE, PRODUCT_TYPE_ID, PRODUCT_NAME, PRODUCT_CODE, PRODUCT_IMG_URL, PRODUCT_DESC, BUY_NUM, activity_ID, ACTIVITY_NAME, DATA_STATE, EXT_1, EXT_2, EXT_3, EXT_4, ID, FIRST_LEVEL_ID, MKT_INV_ID, USER_CODE, TELEPHONE, SERIAL_NUMBER, boxName, boxType, P_SERIAL_NUMBER, PRODUCT_PRICE, PRODUCT_TYPE_ID, PRODUCT_NAME, PRODUCT_CODE, PRODUCT_IMG_URL, PRODUCT_DESC, BUY_NUM, activity_ID, ACTIVITY_NAME, DATA_STATE, EXT_1, EXT_2, EXT_3, EXT_4) values(#{ID}, #{FIRSTLEVELID}, #{MKTINVID}, #{USERCODE}, #{TELEPHONE}, #{SERIALNUMBER}, #{boxName}, #{boxType}, #{PSERIALNUMBER}, #{PRODUCTPRICE}, #{PRODUCTTYPEID}, #{PRODUCTNAME}, #{PRODUCTCODE}, #{PRODUCTIMGURL}, #{PRODUCTDESC}, #{BUYNUM}, #{activityID}, #{ACTIVITYNAME}, #{DATASTATE}, #{EXT1}, #{EXT2}, #{EXT3}, #{EXT4}, #{ID}, #{FIRSTLEVELID}, #{MKTINVID}, #{USERCODE}, #{TELEPHONE}, #{SERIALNUMBER}, #{boxName}, #{boxType}, #{PSERIALNUMBER}, #{PRODUCTPRICE}, #{PRODUCTTYPEID}, #{PRODUCTNAME}, #{PRODUCTCODE}, #{PRODUCTIMGURL}, #{PRODUCTDESC}, #{BUYNUM}, #{activityID}, #{ACTIVITYNAME}, #{DATASTATE}, #{EXT1}, #{EXT2}, #{EXT3}, #{EXT4})")
    int save(AiOrderThirdLevel aiOrderThirdLevel);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiOrderThirdLevel> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
