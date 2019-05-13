package com.netassist.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netassist.mapper.TbSignMapper;
import com.netassist.pojo.TbSign;
import com.netassist.pojo.TbSignExample;
import com.netassist.pojo.TbSignExample.Criteria;
import com.netassist.service.SignService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private TbSignMapper signMapper; 
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSign> findAll() {
		return signMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSign> page=   (Page<TbSign>) signMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbSign sign) {
		signMapper.insert(sign);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbSign sign){
		signMapper.updateByPrimaryKey(sign);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbSign findOne(Integer id){
		return signMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			signMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSign sign, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSignExample example=new TbSignExample();
		Criteria criteria = example.createCriteria();
		
		if(sign!=null){		
			if(sign.getSigntime()!=null) {
			  criteria.andSigntimeEqualTo(sign.getSigntime());	
			}
			
		}
		
		Page<TbSign> page= (Page<TbSign>)signMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public boolean findHasSign(TbSign sign) {
			TbSignExample example=new TbSignExample();
			Criteria criteria = example.createCriteria();
			
			if(sign!=null){			
				criteria.andSigntimeEqualTo(sign.getSigntime());	
				criteria.andSidEqualTo(sign.getSid());
			}
			List<TbSign> list = signMapper.selectByExample(example);
			if(list.size()>0)
				return true;
			return false;
		}
	
}
