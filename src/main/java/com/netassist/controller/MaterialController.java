package com.netassist.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netassist.pojo.TbMaterial;
import com.netassist.pojo.TbTeacher;
import com.netassist.service.MaterialService;
import com.netassist.service.TeacherService;
import com.netassist.util.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	@Autowired
	private TeacherService teacherService;
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbMaterial> findAll(){			
		return materialService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return materialService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param material
	 * @return
	 */
	
	@RequestMapping("/add")
	public String add( TbMaterial material,@RequestParam("files") MultipartFile[] files,HttpSession session,HttpServletRequest request){
		try {
			TbTeacher tbTeacher=(TbTeacher) session.getAttribute("teacher");
			if(tbTeacher!=null) {
				if (files!=null) {// 判断上传的文件是否为空
					System.out.println( files.length);
					for(int i=0;i< files.length;i++) {
						MultipartFile file=files[i];
						  String path=null;// 文件路径
				            String type=null;// 文件类型
				            String fileName=file.getOriginalFilename();// 文件原名称
				            System.out.println("上传的文件原名称:"+fileName);
				            // 判断文件类型
				            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
				            if (type!=null) {// 判断文件类型是否为空
				            	if(i==0) {
				            		if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
					                    // 项目在容器中实际发布运行的根路径
					                    String realPath=request.getSession().getServletContext().getRealPath("upload/");
					                    // 自定义的文件名称
					                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName.substring(fileName.indexOf("."));
					                	   material.setLogo("http://127.0.0.1:8080/upload/"+trueFileName);
					                    
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
				            		if ("TXT".equals(type.toUpperCase())||"PDF".equals(type.toUpperCase())||"DOC".equals(type.toUpperCase())||"DOCX".equals(type.toUpperCase())) {
					                    // 项目在容器中实际发布运行的根路径
					                    String realPath=request.getSession().getServletContext().getRealPath("upload/");
					                    // 自定义的文件名称
					                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName.substring(fileName.indexOf("."));
					                	   material.setUrl("http://127.0.0.1:8080/upload/"+trueFileName);
					                    
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
				            	}
				                
				            }else {
				                System.out.println("文件类型为空");
				              
				                return null;
				            }
					}
		          
				
				} 
				material.setTid(tbTeacher.getId());
				material.setCratetime(DateUtils.getCurrent());
				materialService.add(material);
				System.out.println(material);
				//return new Result(true, "添加成功");
			}else {
				//return new Result(false, "请先登录");
			}
			return "redirect:/teacher/materialList";
			}catch (Exception e) {
			e.printStackTrace();
			//return new Result(false, "添加失败");
			return "redirect:/teacher/materialList";
		}
	}
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbMaterial findOne(@RequestBody TbMaterial material){
		return materialService.findOne(material.getId());		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbMaterial material){
		try {
			materialService.delete(material.getId());
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
	public PageResult search(String key, int page, int limit){
		TbMaterial material=null;
		if(!StringUtils.isEmpty(key)) {
			material=new TbMaterial();
			material.setTitle(key);
		}
		 PageResult result = materialService.findPage(material, page, limit);
		 List<TbMaterial> list = result.getData();
		 for (TbMaterial tbMaterial : list) {
			 TbTeacher tbTeacher = teacherService.findOne(tbMaterial.getTid());
			 tbMaterial.setTeachername(tbTeacher.getUsername());
		}
		return result;
	}
	
}
