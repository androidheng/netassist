package com.netassist.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netassist.mapper.TbTworkMapper;
import com.netassist.pojo.TbTwork;
import com.netassist.pojo.TbTworkExample;
import com.netassist.pojo.TbTworkExample.Criteria;
import com.netassist.service.TworkService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TworkServiceImpl implements TworkService {

	@Autowired
	private TbTworkMapper tworkMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbTwork> findAll() {
		return tworkMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbTwork> page=   (Page<TbTwork>) tworkMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTwork twork) {
		tworkMapper.insert(twork);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbTwork twork){
		tworkMapper.updateByPrimaryKeySelective(twork);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbTwork findOne(Integer id){
		return tworkMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		tworkMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbTwork twork, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbTworkExample example=new TbTworkExample();
		Criteria criteria = example.createCriteria();
		
		if(twork!=null){			
			if(twork.getTitle()!=null) {
				criteria.andTitleEqualTo(twork.getTitle());
			}	
		}
		
		Page<TbTwork> page= (Page<TbTwork>)tworkMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbTwork> findNAll() {
			TbTworkExample example=new TbTworkExample();
			Criteria criteria = example.createCriteria();
			criteria.andEnableEqualTo("Y");
			return tworkMapper.selectByExample(example);
		}
	
}
