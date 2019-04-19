package com.netassist.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.netassist.pojo.TbMaterial;
import com.netassist.pojo.TbTeacher;
import com.netassist.pojo.TbTwork;
import com.netassist.service.TeacherService;
import com.netassist.service.TworkService;
import com.netassist.util.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/twork")
public class TworkController {

	@Autowired
	private TworkService tworkService;
	@Autowired
	private TeacherService teacherService;
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbTwork> findAll(){			
		return tworkService.findAll();
	}
	@RequestMapping("/findYAll")
	public Result findYAll(){			
		List<TbTwork> list=tworkService.findNAll();
		 return new Result(true, list);
	}
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return tworkService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param twork
	 * @return
	 */
	/**
	 * 增加
	 * @param material
	 * @return
	 */
	@RequestMapping("/add")
	public String add( TbTwork twork,@RequestParam("files") MultipartFile file,HttpServletRequest request,HttpSession session){
		try {
			TbTeacher tbTeacher=(TbTeacher) session.getAttribute("teacher");
			if(tbTeacher!=null) {
				if (file!=null) {// 判断上传的文件是否为空
					  String path=null;// 文件路径
			            String type=null;// 文件类型
			            String fileName=file.getOriginalFilename();// 文件原名称
			            System.out.println("上传的文件原名称:"+fileName);
			            // 判断文件类型
			            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
			            if (type!=null) {// 判断文件类型是否为空
			            		if ("TXT".equals(type.toUpperCase())||"PDF".equals(type.toUpperCase())||"DOC".equals(type.toUpperCase())||"DOCX".equals(type.toUpperCase())) {
				                    // 项目在容器中实际发布运行的根路径
				                    String realPath=request.getSession().getServletContext().getRealPath("upload/");
				                    // 自定义的文件名称
				                    String trueFileName=fileName.substring(fileName.indexOf("."));
				                    twork.setFile("http://127.0.0.1:8080/upload/"+trueFileName);
				                    
				                    // 设置存放图片文件的路径
				                    path=realPath+File.separator+trueFileName;
				                    System.out.println("存放图片文件的路径:"+path);
				                    // 转存文件到指定的路径
				                    try {
										file.transferTo(new File(path));
									} catch (IllegalStateException e) {
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
				                    System.out.println("文件成功上传到指定目录下");
				                }else {
				                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
				                   // return new Result(false, "不是我们想要的文件类型,请按要求重新上传");
				                }
			                
			            }else {
			                System.out.println("文件类型为空");
			              
			                return null;
			            }
	          
			
			} 
			twork.setCreatetime(DateUtils.getCurrent());
			tworkService.add(twork);
			//return new Result(true, "添加成功");
			}else {
				//return new Result(false, "请先登录");
			}
			//return "redirect:/teacher/homeWork";
			}catch (Exception e) {
			e.printStackTrace();
			//return new Result(false, "添加失败");
		}
		return "redirect:/teacher/sworklList";
	}
	
	/**
	 * 修改
	 * @param twork
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbTwork twork){
		try {
			tworkService.update(twork);
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
	public TbTwork findOne(Integer id){
		return tworkService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbTwork twork){
		try {
			tworkService.delete(twork.getId());
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
		TbTwork twork=null;
		if(!StringUtils.isEmpty(key)) {
			twork=new TbTwork();
			twork.setTitle(key);
		}
		PageResult result = tworkService.findPage(twork, page, limit);
		List<TbTwork> list = result.getData();
		for (TbTwork tbTwork : list) {
			TbTeacher teacher = teacherService.findOne(tbTwork.getTid());
			tbTwork.setTeachername(teacher.getUsername());
		}
		return 	result;	
	}
	
}
