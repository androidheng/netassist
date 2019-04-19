package com.netassist.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netassist.pojo.TbTeacher;
import com.netassist.service.TeacherService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbTeacher> findAll(){			
		return teacherService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return teacherService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param teacher
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbTeacher teacher){
		try {
			teacherService.add(teacher);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param teacher
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbTeacher teacher){
		try {
			teacherService.update(teacher);
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
	public TbTeacher findOne(Integer id){
		return teacherService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			teacherService.delete(ids);
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
	@ResponseBody
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbTeacher teacher, int page, int limit  ){
		return teacherService.findPage(teacher, page, limit);		
	}
	
	@RequestMapping("materialList")
	public String toMaterialList() {
		return "dataAndInformation";
	}
	
	@RequestMapping("sworklList")
	public String toSworklList() {
		return "homeWork";
	}
	
}
