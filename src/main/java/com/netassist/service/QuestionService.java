package com.netassist.service;
import java.util.List;
import com.netassist.pojo.TbQuestion;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface QuestionService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbQuestion> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbQuestion question);
	
	
	/**
	 * 修改
	 */
	public void update(TbQuestion question);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbQuestion findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer  id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbQuestion question, int pageNum,int pageSize);
	
}
