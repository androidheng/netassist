package com.netassist.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netassist.pojo.TbStudent;
import com.netassist.pojo.TbTeacher;
import com.netassist.service.StudentService;
import com.netassist.service.TeacherService;
import com.netassist.vo.LoginVo;

import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
public class LoginController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/login")
	public Result login(@RequestBody LoginVo loginVo,HttpSession session){	
		if("0".equals(loginVo.getType())) {//学生登录
			TbStudent student=new TbStudent();
			student.setUsername(loginVo.getUsername());
			student.setPassword(loginVo.getPassword());
			TbStudent loginStudent=studentService.findStudent(student);
			if(loginStudent!=null) {
				session.setAttribute("student", loginStudent);
				return new Result(true, "登录成功");
			}else {
				return new Result(false, "登录失败");
			}
			
		}else {//教师登录
			TbTeacher teacher=new TbTeacher();
			teacher.setUsername(loginVo.getUsername());
			teacher.setPassword(loginVo.getPassword());
			TbTeacher loginTeacher=teacherService.findTeacher(teacher);
			if(loginTeacher!=null) {
				session.setAttribute("teacher", loginTeacher);
				return new Result(true, "登录成功");
			}else { 
				return new Result(false, "登录失败");
			}
		}
	}
	
}
