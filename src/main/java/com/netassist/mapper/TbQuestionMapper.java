package com.netassist.mapper;

import com.netassist.pojo.TbQuestion;
import com.netassist.pojo.TbQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbQuestionMapper {
    int countByExample(TbQuestionExample example);

    int deleteByExample(TbQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbQuestion record);

    int insertSelective(TbQuestion record);

    List<TbQuestion> selectByExample(TbQuestionExample example);

    TbQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbQuestion record, @Param("example") TbQuestionExample example);

    int updateByExample(@Param("record") TbQuestion record, @Param("example") TbQuestionExample example);

    int updateByPrimaryKeySelective(TbQuestion record);

    int updateByPrimaryKey(TbQuestion record);
}