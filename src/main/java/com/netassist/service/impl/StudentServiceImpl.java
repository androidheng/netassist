package com.netassist.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netassist.mapper.TbStudentMapper;
import com.netassist.pojo.TbStudent;
import com.netassist.pojo.TbStudentExample;
import com.netassist.pojo.TbStudentExample.Criteria;
import com.netassist.service.StudentService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private TbStudentMapper studentMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbStudent> findAll() {
		return studentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbStudent> page=   (Page<TbStudent>) studentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbStudent student) {
		studentMapper.insert(student);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbStudent student){
		studentMapper.updateByPrimaryKey(student);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbStudent findOne(Integer id){
		return studentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			studentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbStudent student, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbStudentExample example=new TbStudentExample();
		Criteria criteria = example.createCriteria();
		
		if(student!=null){			
				
		}
		
		Page<TbStudent> page= (Page<TbStudent>)studentMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
