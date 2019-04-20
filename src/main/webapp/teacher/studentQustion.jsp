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
            <div class="layui-form-item layui-form-text">
                   <label class="layui-form-label">请输入您的问题</label>
                   <div class="layui-input-block">
                      <textarea placeholder="请输入您的问题" id="answer"  lay-verify="required" name="answer" class="layui-textarea"></textarea>
                  </div>
               </div>
        </div>	
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>学生提问</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                   <div class="demoTable">
                                                                             问题名称：
                      <div class="layui-inline">
                          <input class="layui-input" name="id" id="demoReload" autocomplete="off">
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
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="answer">回复</a>
    </script>
   
    <script>
  layui.use('table', function(){
    var table = layui.table,form = layui.form,$=layui.$;
    //方法级渲染
     table.render({
       elem: '#LAY_table_user'
       ,url: '<%=basePath%>question/search'
       ,cols: [[
         ,{field:'realname', title: '学生姓名', }
         ,{field:'phone', title: '学生电话'}
         ,{field:'question', title: '问题内容'}
         ,{field:'status', title: '是否已回答'}
         ,{field:'replytime', title: '回复时间',  sort: true}
         ,{field:'answer', title: '回复内容', }
         ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
       ]]
       ,id: 'testReload'
       ,page: true
       ,height: 315
     });
     
     var $ = layui.$, active = {
       reload: function(){
         var demoReload = $('#demoReload');
         var dates = $('#dates');
         
         //执行重载
         table.reload('testReload', {
           page: {
             curr: 1 //重新从第 1 页开始
           }
           ,where: {
             key:demoReload.val(),
           }
         });
       }
     };
     
     $('.demoTable .layui-btn').on('click', function(){
       var type = $(this).data('type');
       active[type] ? active[type].call(this) : '';
     });
      
       //监听行工具事件
       table.on('tool(user)', function(obj){
         var data = obj.data;
        
         if(obj.event === 'answer'){
        	 layer.open({
      	         type: 1
      	        ,title: false //不显示标题栏
      	        ,closeBtn: true
      	        ,area: ['600px','400px']
      	        ,shade: 0.8
      	        ,btn:['确定']
      	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
      	        ,btnAlign: 'c'
      	        ,moveType: 1 //拖拽模式，0或者1
      	        ,content: $("#box"),
      	        success:function(){
      	        	
      	        	
      	        }
        	   ,yes:function(index){
        		   let answer = $("#answer").val()
                   if(!answer) return layer.alert('请填写回复内容')
             	   $.ajax({
                        url:"<%=basePath%>question/answer",
                        type:'post',//method请求方式，get或者post
                        dataType:'json',//预期服务器返回的数据类型
                        data:JSON.stringify({id:data.id,answer:answer}),
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
             
           
         
         } 
       });
     
});
   </script>
</body>
</html>