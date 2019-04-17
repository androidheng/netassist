package com.netassist.mapper;

import com.netassist.pojo.TbTwork;
import com.netassist.pojo.TbTworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTworkMapper {
    int countByExample(TbTworkExample example);

    int deleteByExample(TbTworkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTwork record);

    int insertSelective(TbTwork record);

    List<TbTwork> selectByExample(TbTworkExample example);

    TbTwork selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTwork record, @Param("example") TbTworkExample example);

    int updateByExample(@Param("record") TbTwork record, @Param("example") TbTworkExample example);

    int updateByPrimaryKeySelective(TbTwork record);

    int updateByPrimaryKey(TbTwork record);
}