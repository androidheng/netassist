<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/view.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-view-body">
     <div class="layui-content" id="box" style="display:none">
        <div class="layui-form" style="padding:10px 0px;background:#fff;margin-top:50px;"></form>
             <div class="layui-form-item">
              <label class="layui-form-label">输入分数</label>
                <div class="layui-input-block">
                  <input type="number" name="title" id="score" lay-verify="required" autocomplete="off" placeholder="请输入分数" class="layui-input">
                </div>
           </div>
        </div>	
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>作业信息</a>
                </span>
                <h2 class="title">作业信息</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                   <div class="demoTable">
                                                                             作业次数：
                      <div class="layui-inline">
                         <form class="layui-form" action="">
                            <select name="id" id="demoReload" ></select>
                         </form>
                       
                      </div>
                      <button class="layui-btn" data-type="reload">查询</button>
                   </div>
 
                     <table class="layui-hide" id="LAY_table_user" lay-filter="user"></table> 
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
    <script type="text/html" id="barDemo">
       <a class="layui-btn layui-btn-xs" lay-event="doneLoad">下载</a>
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="score">评分</a>
    </script>
   
    <script>
  layui.use('table', function(){
    
     var table = layui.table,form = layui.form,$=layui.$,layer=layui.layer;
   //重新渲染表单
     function renderForm(){
      layui.use('form', function(){
      var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
      form.render();
      });
      }
     getoption('demoReload')
     
     //获取下拉列表数据
     function getoption(id){
        $.ajax({
            url:"<%=basePath%>twork/findYAll ",
            type:'post',//method请求方式，get或者post
            dataType:'json',//预期服务器返回的数据类型
            contentType: "application/json; charset=utf-8",
            success:function(res){//res为相应体,function为回调函数
           	  let options = "<option value=''></option>"
                res.data.forEach(item=>{
               	 options+="<option value='" + item.id + "'>" + item.title + "</option>";
                })
               
                $("#"+id).append(options)
             
                renderForm()
            },
            error:function(){
              layer.alert('操作失败！！！',{icon:5});
            }
          });
     }
 
 
   //方法级渲染
     table.render({
       elem: '#LAY_table_user'
       ,url: '<%=basePath%>swork/search'
       ,cols: [[
    	    {field: 'title', title: '作业标题', }
           ,{field: 'content', title: '作业内容'}
           ,{field: 'teachername', title: '老师名'}
           ,{field: 'createtime', title: '创建时间'}
         ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
       ]]
       ,id: 'testReload'
       ,page: true
       ,height: 315
     });
     
     var $ = layui.$, active = {
       reload: function(){
         var demoReload = $('#demoReload');
         
         //执行重载
         table.reload('testReload', {
           page: {
             curr: 1 //重新从第 1 页开始
           }
           ,where: {
             key:demoReload.val()
           }
         });
       }
     };
     
     $('.demoTable .layui-btn').on('click', function(){
       var type = $(this).data('type');
       active[type] ? active[type].call(this) : '';
     });
      
       //监听行工具事件
       table.on('tool(demo)', function(obj){
         var data = obj.data;
         //打分
         if(obj.event === 'score'){
        	 layer.open({
      	         type: 1
      	        ,title: false //不显示标题栏
      	        ,closeBtn: true
      	        ,area: ['600px','400px']
        	    ,btn:['确定']
      	        ,shade: 0.8
      	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
      	        ,btnAlign: 'c'
      	        ,moveType: 1 //拖拽模式，0或者1
      	        ,content: $("#box"),
      	        success:function(){
      	        	
      	        	
      	        },
      	        yes:function(index){
      	        	$.ajax({
      	                 url:"<%=basePath%>swork/score",
      	                 type:'post',//method请求方式，get或者post
      	                 dataType:'json',//预期服务器返回的数据类型
      	                 data:JSON.stringify({id:data.id,score:$("#score").val()}),
      	                 contentType: "application/json; charset=utf-8",
      	                 success:function(res){//res为相应体,function为回调函数
      	              	      layer.close(index);
      	              	      $(".layui-laypage-btn")[0].click();
      	                 },
      	                 error:function(){
      	                     layer.alert('操作失败！！！',{icon:5});
      	                 }
      	               });
      	        }
      	       ,end:function(index){
      	        	layer.close(index)
      	        }
      	      });
        	 
         } else if(obj.event === 'doneLoad'){
        	 //下载
        	 $.ajax({
	                 url:"<%=basePath%>swork/dowload",
	                 type:'post',//method请求方式，get或者post
	                 dataType:'json',//预期服务器返回的数据类型
	                 data:JSON.stringify({id:data.id}),
	                 contentType: "application/json; charset=utf-8",
	                 success:function(res){//res为相应体,function为回调函数
	              	     //layer.close(index);
	                 },
	                 error:function(){
	                     layer.alert('操作失败！！！',{icon:5});
	                 }
	               });
        	 
         }
       });
     
});
   </script>
</body>
</html>