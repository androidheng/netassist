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
                                                                             学生名称：
                      <div class="layui-inline">
                          <input class="layui-input" name="id" id="demoReload" autocomplete="off">
                      </div>
                                                                             签到日期：
                      <div class="layui-inline">
                          <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
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
       <a class="layui-btn layui-btn-xs" lay-event="edit">下载</a>
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">评分</a>
    </script>
   
    <script>
       layui.use('laydate', function(){
    	  var laydate = layui.laydate;
    	   //常规用法
    	  laydate.render({
    	    elem: '#test1'
    	  });
      });
      layui.use('table', function(){
    
     var table = layui.table,form = layui.form,$=layui.$
    
    //方法级渲染
     table.render({
       elem: '#LAY_table_user'
       ,url: '<%=basePath%>sign/search'
       ,cols: [[
         ,{field:'username', title: '用户名', width:80}
         ,{field:'sex', title: '性别', width:80, sort: true}
         ,{field:'city', title: '城市', width:80}
         ,{field:'sign', title: '签名'}
         ,{field:'experience', title: '积分', sort: true, width:80}
         ,{field:'score', title: '评分', sort: true, width:80}
         ,{field:'classify', title: '职业', width:80}
         ,{field:'wealth', title: '财富', sort: true, width:135}
         ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
       ]]
       ,id: 'testReload'
       ,page: true
       ,height: 315
     });
     
     var $ = layui.$, active = {
       reload: function(){
         var demoReload = $('#demoReload');
         var dates = $('#test1');
         
         //执行重载
         table.reload('testReload', {
           page: {
             curr: 1 //重新从第 1 页开始
           }
           ,where: {
             key: {
               id: demoReload.val(),
               dates: dates.val(),
             }
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