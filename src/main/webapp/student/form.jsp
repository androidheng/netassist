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
     
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>我的签到</a>
                </span>
              
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                                                                             签到时间：
                      <div class="layui-inline">
                          <input type="text" class="layui-input" id="demoReload" placeholder="yyyy-MM-dd">
                      </div>
                      <button class="layui-btn" data-type="reload">查询</button>
                    </div>
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
     <script type="text/html" id="toolbarDemo">
       <div class="layui-btn-container">
          <button class="layui-btn layui-btn-sm" lay-event="sgin">签到</button>
       </div>
    </script>
    
   
    <script>
   
    layui.use('laydate', function(){
    	  var laydate = layui.laydate;
    	  
    	  //常规用法
    	  laydate.render({
    	    elem: '#demoReload'
    	  });
    })
    layui.use('table', function(){
    	var table = layui.table,form = layui.form,$=layui.$;
    	//展示已知数据
        table.render({
           elem: '#demo'
          ,toolbar: '#toolbarDemo'
          ,url:'<%=basePath%>sign/search'
          ,cols: [[ //标题栏
             {field: 'signtime', title: '签到时间', }
           
           
         ]]
        ,id:'testReload'
        ,skin: 'line' //表格风格
        ,even: true
        ,page: true //是否显示分页
        ,limits: [5, 7, 10]
        ,limit: 5 //每页默认显示的数量
       });
       var  active = {
    	       reload: function(){
    	         var demoReload = $('#demoReload');
    	          //执行重载
    	         table.reload('testReload', {
    	           page: {
    	             curr: 1 //重新从第 1 页开始
    	           }
    	           ,where: {
    	             key: demoReload.val()
    	           }
    	         });
    	       }
    	     };
    	     
    	     $('.demoTable .layui-btn').on('click', function(){
    	       var type = $(this).data('type');
    	       active[type] ? active[type].call(this) : '';
    	     });
       
        //签到
        //获取当前时间，格式YYYY-MM-DD
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    }
    	function sgin(){
    		 $.ajax({
                 url:"<%=basePath%>sign/add",
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 data:JSON.stringify({"signtime":getNowFormatDate()}),
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
              	  
                     $(".layui-laypage-btn")[0].click();
                  
                 },
                 error:function(){
                     layer.alert('操作失败！！！',{icon:5});
                 }
               });
        }
       //头工具栏事件
       table.on('toolbar(demo)', function(obj){
         switch(obj.event){
           case 'sgin':
        	   sgin()
           break;
         
         };
       });
      
});
   </script>
</body>
</html>