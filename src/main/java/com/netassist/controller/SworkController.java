package com.netassist.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.netassist.pojo.TbStudent;
import com.netassist.pojo.TbSwork;
import com.netassist.pojo.TbTeacher;
import com.netassist.service.StudentService;
import com.netassist.service.SworkService;
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
@RequestMapping("/swork")
public class SworkController {

	@Autowired
	private SworkService sworkService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSwork> findAll(){			
		return sworkService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return sworkService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param swork
	 * @return
	 */
	@RequestMapping("/add")
	public String add( TbSwork swork,@RequestParam("files") MultipartFile file,HttpSession session,HttpServletRequest request){
		try {
			TbStudent tbStudent=(TbStudent) session.getAttribute("student");
			if(tbStudent!=null) {
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
				                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName.substring(fileName.indexOf("."));
				                    swork.setFile("http://127.0.0.1:8080/upload/"+trueFileName);
				                    
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
			swork.setSid(tbStudent.getId());
			swork.setCommittime(DateUtils.getCurrent());
			sworkService.add(swork);
			}else {
			}
			
			}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/student/sworklList";
	}
	
	/**
	 * 修改
	 * @param swork
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbSwork swork){
		try {
			sworkService.update(swork);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	/**
	 * 下载作业
	 * @param swork
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dowload")
	public ResponseEntity<byte[]> dowload(String id){
		try {
			TbSwork tbSwork = sworkService.findOne(Integer.parseInt(id));
			tbSwork.setIsdowload("Y");
			sworkService.update(tbSwork);
			
			String downloadFilePath=tbSwork.getFile();//从我们的上传文件夹中去取
	        
	        File file = new File(downloadFilePath);//新建一个文件
	        
	        HttpHeaders headers = new HttpHeaders();//http头信息
	        
	        String downloadFileName = new String(downloadFilePath.getBytes("UTF-8"),"iso-8859-1");//设置编码
	        
	        headers.setContentDispositionFormData("attachment", downloadFileName);
	        
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        
	        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
	        
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);	
		} catch (Exception e) {
			
		}
		return null;	
	}	
	/**
	 * 分数
	 * @param swork
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/score")
	public Result score(@RequestBody TbSwork swork,HttpSession session){
		try {
			TbTeacher tbTeacher=(TbTeacher) session.getAttribute("teacher");
			if(tbTeacher!=null) {
				if(sworkService.findOne(swork.getId()).getIsdowload().equals("Y")) {
					swork.setTid(tbTeacher.getId());
					sworkService.update(swork);
					return new Result(true, "批改成功");
				}else {
					return new Result(false, "请先下载作业");
				}
				
			}else {
				return new Result(false, "请先登录");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "下载失败");
		}
	}
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbSwork findOne(Integer id){
		return sworkService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbSwork swork){
		try {
			sworkService.delete(swork.getId());
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
	public PageResult search(String key , int page, int limit  ){
		TbSwork swork=null;
		if(!StringUtils.isEmpty(key)) {
			swork=new TbSwork();
			swork.setTtid(Integer.parseInt(key));
		}
		PageResult result = sworkService.findPage(swork, page, limit);
		List<TbSwork> list = result.getData();
		for (TbSwork tbSwork : list) {
			if(!StringUtils.isEmpty(tbSwork.getTid())) {
				tbSwork.setTeachername(teacherService.findOne(tbSwork.getTid()).getUsername());
				tbSwork.setStatus("已批改");
			}
			tbSwork.setStuname(studentService.findOne(tbSwork.getSid()).getUsername());
		}
		return 	result;
	}
	@ResponseBody
	@RequestMapping("/myWork")
	public PageResult myWork(String key , int page, int limit,HttpSession session  ){
		TbStudent tbStudent=(TbStudent) session.getAttribute("student");
		if(tbStudent!=null) {
			TbSwork swork=new TbSwork();
			if(!StringUtils.isEmpty(key)) {
				swork.setTtid(Integer.parseInt(key));
			}
			PageResult result = sworkService.findPage(swork, page, limit);
			List<TbSwork> list = result.getData();
			for (TbSwork tbSwork : list) {
				if(!StringUtils.isEmpty(tbSwork.getTid())) {
					tbSwork.setTeachername(teacherService.findOne(tbSwork.getTid()).getUsername());
					tbSwork.setStatus("已批改");
				}
				tbSwork.setStuname(studentService.findOne(tbSwork.getSid()).getUsername());
			}
			return 	result;
		}else {
			return null;
		}
	
	}
	
}
