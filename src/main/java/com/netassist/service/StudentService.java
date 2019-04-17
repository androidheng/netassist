package com.netassist.service;
import java.util.List;
import com.netassist.pojo.TbStudent;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface StudentService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbStudent> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbStudent student);
	
	
	/**
	 * 修改
	 */
	public void update(TbStudent student);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbStudent findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbStudent student, int pageNum,int pageSize);


	public TbStudent findStudent(TbStudent student);
	
}
