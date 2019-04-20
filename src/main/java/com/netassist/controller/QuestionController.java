package com.netassist.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.netassist.pojo.TbQuestion;
import com.netassist.pojo.TbStudent;
import com.netassist.pojo.TbTeacher;
import com.netassist.service.QuestionService;
import com.netassist.service.TeacherService;
import com.netassist.util.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbQuestion> findAll(){			
		return questionService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return questionService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param question
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbQuestion question,HttpSession session){
		try {
			TbStudent loginStudent=(TbStudent) session.getAttribute("student");
			if(loginStudent!=null) {
				question.setSid(loginStudent.getId());
				question.setCreatetime(DateUtils.getCurrent());
				questionService.add(question);
				return new Result(true, "提问成功");	
			}else {
				return new Result(false, "请先登录");	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param question
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbQuestion question){
		try {
			questionService.update(question);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	@RequestMapping("/answer")
	public Result answer(@RequestBody TbQuestion question,HttpSession session){
		try {
			TbTeacher tbTeacher=(TbTeacher) session.getAttribute("teacher");
			if(tbTeacher!=null) {
				question.setTid(tbTeacher.getId());
				questionService.update(question);
				return new Result(true, "回答成功");
			}else {
				return new Result(false, "请先登录");
			}
			
			
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
	public TbQuestion findOne(Integer id){
		return questionService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			questionService.delete(ids);
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
	public PageResult search(String key, int page, int limit  ){
		TbQuestion question=null;
		if(!StringUtils.isEmpty(key)) {
			question=new TbQuestion();
			question.setQuestion(key);
		}
		PageResult result = questionService.findPage(question, page, limit);
		List<TbQuestion> list = result.getData();
		for (TbQuestion tbQuestion : list) {
			if(!StringUtils.isEmpty(tbQuestion.getTid())) {
				tbQuestion.setStatus("已回答");
				tbQuestion.setTeachername(teacherService.findOne(tbQuestion.getTid()).getUsername());
			}
		}
		return result;
	}
	@RequestMapping("/myQuestion")
	public PageResult myQuestion(String key, int page, int limit,HttpSession session){
		TbStudent loginStudent=(TbStudent) session.getAttribute("student");
		if(loginStudent!=null) {
			TbQuestion question=new TbQuestion();
			if(!StringUtils.isEmpty(key)) {
				question.setQuestion(key);
			}
			question.setSid(loginStudent.getId());
			PageResult result = questionService.findPage(question, page, limit);
			List<TbQuestion> list = result.getData();
			for (TbQuestion tbQuestion : list) {
				if(!StringUtils.isEmpty(tbQuestion.getTid())) {
					tbQuestion.setStatus("已回答");
					tbQuestion.setTeachername(teacherService.findOne(tbQuestion.getTid()).getUsername());
				}
			}
			return result;
		}else {
			return null;
			//return new Result(false, "请先登录");	
		}
		
	}
}
