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
        <link rel="stylesheet" href="http://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-view-body">
     <div class="layui-content" id="box" style="display:none">
           <div class="wrapper" >
	<div id="container" style="height:500px;"></div>
	<div class="input-card" style="position:relative;top: 20px;">
		<label style='color:grey'>请输入或点击地图获取经纬度：(经度,纬度)</label>
		<div class="input-item">
			<div class="input-item-prepend">
				<span class="input-item-text" >经纬度</span>
			</div>
			<input id='lnglat' type="text" value="">
		</div>
  </div>
  <div class="layui-form" style="padding:10px 0px;background:#fff;margin-top:50px;"></form>
      <div class="layui-form-item">
        <label class="layui-form-label">输入站点名称</label>
        <div class="layui-input-block">
          <input id='city' type="text" value="">
        </div>
      </div>
    </div>	
</div>

           
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>站点信息</a>
                </span>
                <h2 class="title">站点信息</h2>
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
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.14&key=4f4388a14723c2fc91b750e5f9b0ce33&plugin=AMap.Geocoder"></script>
   <script type="text/html" id="toolbarDemo">
     <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加站点</button>
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
          ,url:'<%=basePath%>city/search'
          ,cols: [[ //标题栏
             {field: 'city', title: '站点名称', }
            ,{field: 'lat', title: '站点经度'}
            ,{field: 'lon', title: '站点纬度'}
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
  	        ,area: ['1000px','800px']
  	        ,shade: 0.8
  	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
  	        ,btn: ['确定']
  	        ,btnAlign: 'c'
  	        ,moveType: 1 //拖拽模式，0或者1
  	        ,content: $("#box"),
  	         yes:function(){
  	        	let parames = {
  	        		lat:$('#lnglat').val().split(',')[0],
  	        		lon:$('#lnglat').val().split(',')[1],
  	        		city:$("#city").val()
  	        	}
  	        	 $.ajax({
  	                   url:"<%=basePath%>city/addOrUpdate",
  	                   type:'post',//method请求方式，get或者post
  	                   dataType:'json',//预期服务器返回的数据类型
  	                   data:JSON.stringify(parames),
  	                   contentType: "application/json; charset=utf-8",
  	                   success:function(res){//res为相应体,function为回调函数
  	                	   if(res.success){
  	                		   layer.close(1);
  	                	   }else{
  	                		   layer.alert('操作失败！！！',{icon:5});
  	                	   }
  	                      
  	                    
  	                   },
  	                   error:function(){
  	                       layer.alert('操作失败！！！',{icon:5});
  	                   }
  	            });
  	        }
  	        ,success: function(layero){
  	        	 let center = [data.lat,data.lon]||[114.147977,30.681939] //设置地图中心
  	        	 var map = new AMap.Map("container", {
  	        	        resizeEnable: true,
  	        			center: center,
  	        	    });

  	        	   
  	        	    var lnglatInput = $('#lnglat');
  	        	    if(data){
  	        	    	$("#city").val(data.city)
  	        	    	lnglatInput.val(data.lat+','+data.lon)
  	        	    	console.log(lnglatInput.val())
  	        	    }
  	        	   
  	        	    map.on( 'click',  function (e) {
  	        	        lnglatInput.val(e.lnglat.toString()) ;
  	        	    });

  	        		var marker = new AMap.Marker({
  	        	        position:center,
  	        	        icon: 'http://a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png',
  	        	        // offset: new AMap.Pixel(-13, -30),
  	        	        // 设置是否可拖拽
  	        	        draggable: false,
  	        	        cursor: 'move'
  	        	    });
  	        		marker.on('click', function(e){
  	        	        console.log(e)
  	        	    });

  	        	    marker.setMap(map);
  	          
  	        },end:function(){
  	        	layer.close(0)
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
                   url:"<%=basePath%>city/delete",
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