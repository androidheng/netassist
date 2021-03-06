package com.netassist.service;
import java.util.List;
import com.netassist.pojo.TbMaterial;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface MaterialService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbMaterial> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbMaterial material);
	
	
	/**
	 * 修改
	 */
	public void update(TbMaterial material);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbMaterial findOne(Integer id);
	
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbMaterial material, int pageNum,int pageSize);
	
}
