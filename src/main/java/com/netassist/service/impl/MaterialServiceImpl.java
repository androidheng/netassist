package com.netassist.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netassist.mapper.TbMaterialMapper;
import com.netassist.pojo.TbMaterial;
import com.netassist.pojo.TbMaterialExample;
import com.netassist.pojo.TbMaterialExample.Criteria;
import com.netassist.service.MaterialService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private TbMaterialMapper materialMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbMaterial> findAll() {
		return materialMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbMaterial> page=   (Page<TbMaterial>) materialMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbMaterial material) {
		materialMapper.insert(material);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbMaterial material){
		materialMapper.updateByPrimaryKey(material);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbMaterial findOne(Integer id){
		return materialMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			materialMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbMaterial material, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbMaterialExample example=new TbMaterialExample();
		Criteria criteria = example.createCriteria();
		
		if(material!=null){			
				
		}
		
		Page<TbMaterial> page= (Page<TbMaterial>)materialMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
