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
          <form class="layui-form layui-form-pane" method="post" enctype="multipart/form-data" style="padding:20px;" action="">
            <div class="layui-form-item">
              <label class="layui-form-label">输入标题</label>
                <div class="layui-input-block">
                  <input type="text" name="title" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
                </div>
           </div>
           <div class="layui-form-item">
             <label class="layui-form-label">选择图片</label>
             <div class="layui-input-inline">
               <input type="file" name="file" lay-verify="required"  class="layui-input">
             </div>
           </div>
           <div class="layui-form-item">
            <label class="layui-form-label">选择文件</label>
            <div class="layui-input-inline">
              <input type="file" name="file" lay-verify="required"  class="layui-input">
            </div>
           </div>
          <div class="layui-form-item layui-form-text">
             <label class="layui-form-label">简介</label>
             <div class="layui-input-block">
                <textarea placeholder="请输入简介内容"  lay-verify="required" name="content" class="layui-textarea"></textarea>
             </div>
          </div>
          <div class="layui-form-item">
             <button class="layui-btn" lay-submit="" lay-filter="upload">提交</button>
           </div>
      </form>
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>站长信息</a>
                </span>
                <h2 class="title">资料信息</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <table id="demo" lay-filter="demo" ></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
     <script type="text/html" id="toolbarDemo">
     <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加作业</button>
     </div>
    </script>
    <script type="text/html" id="barDemo">
       <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
   
    <script>
  layui.use('table', function(){
    
     var table = layui.table,form = layui.form,$=layui.$;
       //展示已知数据
       table.render({
           elem: '#demo'
          ,toolbar: '#toolbarDemo'
          ,url:'<%=basePath%>user/search'
          ,cols: [[ //标题栏
             {field: 'city', title: '站点名称', }
            ,{field: 'username', title: '用户名'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
         ]]
        ,skin: 'line' //表格风格
        ,even: true
        ,page: true //是否显示分页
        ,limits: [5, 7, 10]
        ,limit: 5 //每页默认显示的数量
       });
       
    
       //打开添加站点弹窗
       function getCitys(data){
    	   layer.open({
  	         type: 1
  	        ,title: false //不显示标题栏
  	        ,closeBtn: true
  	        ,area: ['600px','400px']
  	        ,shade: 0.8
  	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
  	        ,btn: ['确定']
  	        ,btnAlign: 'c'
  	        ,moveType: 1 //拖拽模式，0或者1
  	        ,content: $("#box"),
  	         yes:function(index){
  	        	let parames = {
  	        		username:$('#userName').val(),
  	        		password:$('#password').val(),
  	        		cid:$("#cid").val()
  	        	}
  	        	data&&(parames.id=data.id);
  	        	
  	        	 $.ajax({
  	                   url:"<%=basePath%>user/addOrUpdate",
  	                   type:'post',//method请求方式，get或者post
  	                   dataType:'json',//预期服务器返回的数据类型
  	                   data:JSON.stringify(parames),
  	                   contentType: "application/json; charset=utf-8",
  	                   success:function(res){//res为相应体,function为回调函数
  	                	   if(res.success){
  	                		   layer.close(index);
  	                		  $(".layui-laypage-btn")[0].click();
  	                		 }else{
  	                		   layer.alert('操作失败！！！',{icon:5});
  	                	   }
  	                    },
  	                   error:function(){
  	                       layer.alert('操作失败！！！',{icon:5});
  	                   }
  	            });
  	        },success:function(){
  	        	
  	        	
  	        }
  	       ,end:function(index){
  	        	layer.close(index)
  	        }
  	      });
  	   
       }
       //头工具栏事件
       table.on('toolbar(demo)', function(obj){
         switch(obj.event){
           case 'add':
             getCitys()
           break;
         
         };
       });
       //监听行工具事件
       table.on('tool(demo)', function(obj){
         var data = obj.data;
         //console.log(obj)
         if(obj.event === 'del'){
           layer.confirm('真的删除行么', function(index){
        	  $.ajax({
                   url:"<%=basePath%>user/delete",
                   type:'post',//method请求方式，get或者post
                   dataType:'json',//预期服务器返回的数据类型
                   data:JSON.stringify({id:data.id}),
                   contentType: "application/json; charset=utf-8",
                   success:function(res){//res为相应体,function为回调函数
                	   obj.del();
                       layer.close(index);
                    
                   },
                   error:function(){
                       layer.alert('操作失败！！！',{icon:5});
                   }
                 });
           
           });
         } else if(obj.event === 'edit'){
        	 getCitys(data)
         }
       });
     
});
   </script>
</body>
</html>