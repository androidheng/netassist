package com.netassist.mapper;

import com.netassist.pojo.TbMaterial;
import com.netassist.pojo.TbMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMaterialMapper {
    int countByExample(TbMaterialExample example);

    int deleteByExample(TbMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbMaterial record);

    int insertSelective(TbMaterial record);

    List<TbMaterial> selectByExample(TbMaterialExample example);

    TbMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbMaterial record, @Param("example") TbMaterialExample example);

    int updateByExample(@Param("record") TbMaterial record, @Param("example") TbMaterialExample example);

    int updateByPrimaryKeySelective(TbMaterial record);

    int updateByPrimaryKey(TbMaterial record);
}