package com.netassist.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netassist.mapper.TbQuestionMapper;
import com.netassist.pojo.TbQuestion;
import com.netassist.pojo.TbQuestionExample;
import com.netassist.pojo.TbQuestionExample.Criteria;
import com.netassist.service.QuestionService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private TbQuestionMapper questionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbQuestion> findAll() {
		return questionMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbQuestion> page=   (Page<TbQuestion>) questionMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbQuestion question) {
		questionMapper.insert(question);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbQuestion question){
		questionMapper.updateByPrimaryKeySelective(question);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbQuestion findOne(Integer id){
		return questionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			questionMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbQuestion question, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbQuestionExample example=new TbQuestionExample();
		Criteria criteria = example.createCriteria();
		
		if(question!=null){			
			criteria.andQuestionLike("%"+question.getQuestion()+"%");	
		}
		
		Page<TbQuestion> page= (Page<TbQuestion>)questionMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
