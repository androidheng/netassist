<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/admin.css">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header custom-header">
            
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item slide-sidebar" lay-unselect>
                    <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">Admin</a>
                    <dl class="layui-nav-child">
                        <dd><a href="">帮助中心</a></dd>
                        <dd><a href="<%=basePath%>login.jsp">退出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>

        <div class="layui-side custom-admin">
            <div class="layui-side-scroll">

                <div class="custom-logo">
                    
                    <h1>后台管理系统</h1>
                </div>
                <ul id="Nav" class="layui-nav layui-nav-tree">

 					<li class="layui-nav-item">
                         <a href="<%=basePath%>student/homeWork.jsp">
                               <i class="layui-icon">&#xe62a;</i>
                               <em>我的作业</em>
                         </a>
                    </li>
                    <li class="layui-nav-item">
                         <a href="<%=basePath%>student/form.jsp">
                              <i class="layui-icon">&#xe637;</i>
                               <em>我的签到 </em>
                         </a>
                        </li>
                    <li class="layui-nav-item">
                            <a href="<%=basePath%>student/order.jsp">
                                <i class="layui-icon">&#xe63a;</i>
                                <em>我的提问</em>
                            </a>
                        </li>
                </ul>
           </div>
        </div>

        <div class="layui-body">
             <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
                <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
                <div id="appTabPage" class="layui-tab-content"></div>
            </div>
        </div>

        <div class="layui-footer">
            <p>© 2018 DEMO</p>
        </div>

        <div class="mobile-mask"></div>
    </div>
    <script src="<%=basePath%>assets/layui.js"></script>
    <script src="<%=basePath%>js/index.js" data-main="home"></script>
</body>
</html>