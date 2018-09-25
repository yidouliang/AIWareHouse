package com.boot.security.server.dao;

import com.boot.security.server.model.OrderThirdLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderThirdLevelDao {

    int count(@Param("params") Map<String, Object> params,@Param("id")  Long id);

    List<OrderThirdLevel> listThirdLevel(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit,@Param("id") Long id);
}
