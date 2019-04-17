package com.netassist.service;
import java.util.List;
import com.netassist.pojo.TbSign;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SignService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbSign> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbSign sign);
	
	
	/**
	 * 修改
	 */
	public void update(TbSign sign);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbSign findOne(Integer id);
	
	
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
	public PageResult findPage(TbSign sign, int pageNum,int pageSize);
	
}
