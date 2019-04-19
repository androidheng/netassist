package com.netassist.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.netassist.pojo.TbSign;
import com.netassist.service.SignService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/sign")
public class SignController {

	@Autowired
	private SignService signService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSign> findAll(){			
		return signService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return signService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param sign
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbSign sign){
		try {
			signService.add(sign);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param sign
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbSign sign){
		try {
			signService.update(sign);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbSign findOne(Integer id){
		return signService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			signService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(String key , int page, int limit  ){
		TbSign sign=null;
		if(!StringUtils.isEmpty(key)) {
			sign=new TbSign();
			sign.setSigntime(key);
		}
		return signService.findPage(sign, page, limit);		
	}
	
}
