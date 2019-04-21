<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>计算机网络</title>
    <link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/ee.css">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="<%=basePath%>swiper-master/dist/amazeui.swiper.min.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.min.css">
    <style type="text/css">
      .dataImformation{
        width:1000px;
        margin:auto;
        display:flex;
      }
      .dataImformation li{
         padding:80px;
         box-sizing:border-box;
         flex:1;
        
      }
       .dataImformation li>div{
          border:2px solid #999;
          padding-bottom:5px;
       }
      .dataImformation li img{
        width:345px;
        height:350px;
      }
       .dataImformation li p{
         padding:0 5px;
        width:345px;
        white-space:normal;
      }
      .dataImformation li a{
         display:inline-block;
         width:100px;
         line-height:30px;
         text-align:center;
         border-radius:15px;
         background:#999;
      }
      .goUpload{
        width:100%;
        text-align:center;
      }
    
    </style>
</head>
<body>
    <script src="<%=basePath%>assets/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>assets/js/amazeui.min.js"></script>
    <div class="am-g">
      <div class="am-u-sm-4 am-text-right" >
        <br>
       <img src="<%=basePath%>images/dingbu.png" >
      </div>
      <div class="am-u-sm-8 am-text-center am-u-end" >
        <br>
        <img src="<%=basePath%>images/dinbu.jpg" >
      </div>
  
    </div>
    <div class="nav">
        
        <ul>
          <li><a href="SHouYe.html">首页</a>
          </li>
          <li><a href="#A1">参考手册</a>

          <li><a href="#A2">学生成果展示</a></li>
          <li><a href="#A3">导师风采</a></li>
          <li><a href="#">联系我们</a></li>
          <li><a href="<%=basePath%>login.jsp">登录</a></li>
        </ul>
      </div>
      <div class="am-g">
          <div class="am-u-sm-12 am-text-right">
              <div class="am-slider am-slider-default" data-am-flexslider="{playAfterPaused: 8000}">
                  <ul class="am-slides">
              <li>
                  <img src="<%=basePath%>images捕获.PNG">
                 
              </li>
              <li>
                  <img src="<%=basePath%>images捕获2.PNG">
                 
              </li>
              <li>
                  <img src="<%=basePath%>images捕获3.PNG">
                 
              </li>
          </ul>
        </div>
      </div>
      </div>
    
          <div class="am-g" >
              <div class="am-u-sm-12 am-text-right ">
                <div class="ad" >
                   <a name="A1">参考手册</a> 
                </div>
              </div>
          
            </div>
<br>
<ul class="dataImformation" id="dataImformation">
    <li v-for="item in data">
        <div>
           <img :src="item.logo" >
           <p>{{item.introduction}}学生成果展示学生成果展示学生成果展示学生成果展示学生成果展示学生成果展示学生成果展示学生成果展示</p>
           <div class="goUpload">
              <a :href="item.url">去下载</a>
           </div>
          
        </div>
    </li>
    
</ul>

<div class="am-g" >
    <div class="am-u-sm-12 am-text-right ">
      <div class="ac" >
         <a name="A2">学生成果展示</a> 
      </div>
    </div>

  </div>

<br>
<div class="am-g">
  <div class="am-u-sm-3">
   <div class="responsive">
    <div class="img">
      <a target="_blank" href="#">
        <img src="<%=basePath%>images/实验1.jpg" alt="图片文本描述" width="500" height="200">
      </a>
      <div class="desc">为网络接口配置IP地址、子网掩码、默认网关、DNS服务器IP地址信息。开始配置时与第1部查看的结果是一致的，然后分别试着调整IP地址、子网掩码、默认网关、DNS服务器IP地址信息，观察可能带来些什么问题。
      </div>
    </div>
    </div>
  </div>
  <div class="am-u-sm-3">
   <div class="responsive">
    <div class="img">
      <a target="_blank" href="#">
        <img src="<%=basePath%>images/实验2.jpg" alt="图片文本描述" width="500" height="200">
      </a>
      <div class="desc">启动Ethereal分组俘获器。开始Ethereal分组俘获。
          在浏览器的地址栏中输入下URL,你的浏览器中将显示一个具有五行的非常简单的HTML文件。
          在你的浏览器中重新输入相同的URL或单击浏览器中的“刷新”按钮。
</div>
</div>
    </div>
  </div>
  <div class="am-u-sm-3">
  <div class="responsive">
    <div class="img">
      <a target="_blank" href="#">
        <img src="<%=basePath%>images/实验3.jpg" alt="图片文本描述" width="500" height="200">
      </a>
      <div class="desc">实现一个能够在局域网中进行点对点聊天的实用程序。

         熟悉c++、Java等高级编程语言网络编程的基本操作。
          
          基本了解对话框应用程序的编写过程。 实现TCP套接字编程。</div>
    </div>
  </div>
  </div>
  <div class="am-u-sm-2 am-u-end" >
  <div class="responsive">
    <div class="img">
      <a target="_blank" href="#">
        <img src="<%=basePath%>images/实验4.jpg" alt="图片文本描述" width="500" height="200">
      </a>
      <div class="desc">通过路由器交换机连接真机进行校园局域网的测试。只需要用一根网线，一头连接到第一个路由器的LAN，网线的另一头连接到交换机上即可，电脑用网线连接到交换机上其他接口。         </div>
    </div>
  </div>
</div>
</div>
<div class="af">


  <div class="am-g" >
      <div class="am-u-sm-12 am-text-right ">
        <div class="ae" >
           <a name="A3">导师风采</a> 
        </div>
      </div>
  
    </div>
  
  <br>
  <div id="tutor">

      <div class="am-container" style="margin-top:12px; margin-right: 25%;">
        <div class="swiper-container " id="tutor-swiper">
          <div class="swiper-wrapper">
            <div class="swiper-slide">
              <div class="slide-room">
                <div class="ellipse">
                  <img src="<%=basePath%>imagestubiao.png" width="90px" style=" position: absolute; top:20px; left: 35px;">

                  <div class="ma">王则林</div>
                  <div class="ma-a">
                    <h>职称：副教授</h><br>
                    <h>研究领域：智能算法、</h><br>
                    <h>网络安全</h><br>

                  </div>
                </div>

              </div>
            </div>
            <div class="swiper-slide">
              <div class="slide-room">
                <div class="ellipse">
                  <img src="<%=basePath%>images/tubiao.png" width="90px" style=" position: absolute; top:20px; left: 35px;">
                  <div class="ma">马海英</div>
                  <div class="ma-a">
                    <h>职称：副教授</h><br>
                    <h>研究领域介绍：
                        物联网安全</h><br>
                    <h>大数据隐私保护</h><br>

                  </div>
                </div>

              </div>
            </div>
            <div class="swiper-slide">
              <div class="slide-room">
                <div class="ellipse">
                  <img src="<%=basePath%>images/tubiao.png" width="90px" style=" position: absolute; top:20px; left: 35px;">
                  <div class="ma">曹利</div>
                  <div class="ma-a">
                    <h>职称：副教授</h><br>
                    <h>研究领域介绍：
                        加密技术研究</h><br>
                    <h>无线网的安全认证机制</h><br>

                  </div>
                </div>

              </div>
            </div>
            <div class="swiper-slide">
              <div class="slide-room">
                <div class="ellipse">
                  <img src="<%=basePath%>images/tubiao.png" width="90px" style=" position: absolute; top:20px; left: 35px;">
                  <div class="ma">王进</div>
                  <div class="ma-a">
                    <h>职称：副教授</h><br>
                    <h>研究领域介绍：物联网智能控制</h><br>
                    <h>推荐系统</h><br>

                  </div>
                </div>

              </div>
            </div>
            <div class="swiper-slide">
              <div class="slide-room">
                <div class="ellipse">
                  <img src="<%=basePath%>images/tubiao.png" width="90px" style=" position: absolute; top:20px; left: 35px;">

                  <div class="ma">陆培军</div>
                  <div class="ma-a">
                    <h>职称：副教授</h><br>
                    <h>研究领域介绍：大数据与机器学习</h><br>
                    <h>WEB大数据挖掘</h><br>

                  </div>
                </div>

              </div>
            </div>
            <div class="swiper-slide">
              <div class="slide-room">
                <div class="ellipse">
                  <img src="<%=basePath%>images/tubiao.png" width="90px" style=" position: absolute; top:20px; left: 35px;">

                  <div class="ma">王春明</div>
                  <div class="ma-a">
                    <h>职称：副教授</h><br>
                    <h>研究领域介绍：物联网工程技术及应用</h><br>
                    <h>计算机软件开发</h><br>

                  </div>
                </div>

              </div>
            </div>

          </div>

        </div>
</div>

      </div>
    </div>



    <div class="fa">
        <div class="am-g">
          <div class="am-u-sm-3 ">
    
            <br>
    
            <br>
    
          </div>
          <div class="am-u-sm-2">
            <br>
            <br>
            <br>
            <div class="fa-a">
              <h>学生问题：</h>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              

            </div>
    
            
          </div>
          <br>
          <br>
         
          <div class="am-u-sm-2 am-u-end">
    
    
            <div class="fa-a-k ">
              <h>在线提问
              </h>
            </div>
    
            <input id="userName" type="text" placeholder="请输入您的姓名"  name="name" class="fa-c">
            <br>
            <input id="userPhone" type="text" placeholder="请输入您的电话"  name="number" class="fa-c" />
            <br>
            <textarea id="qustion" placeholder="请输入您的问题" cols="50" rows="5" class="fa-d"></textarea>
    
            <a ><button onclick="upload()" class="fa-c-g">提交</button></a>
    
    
          </div>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>

    

    <script src="<%=basePath%>assets/js/jquery-1.11.0.min.js"></script>
    <script src="<%=basePath%>swiper-master/dist/amazeui.swiper.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
  <script>

        $(function () {
        	
          var a = 4
          var b = 5
          if (window.screen.width < 500) {
            // window.screen.width 返回当前屏幕宽度(分辨率值) 
            a = 1
            b = 1
          }
          console.log(a, b)
          $('#tutor-swiper').swiper({
            pagination: '#tutor-swiper .swiper-pagination',
            // 分页器
            slidesPerView: b,
            loop: true,
            loopedSlides: 6,
            // 旋转模式下，设置slider’s容器能够同时显示的slides数量。
            // 另外，支持’auto’值，会根据容器container的宽度调整slides数目。
            // ‘auto’不兼容loop模式.
            // 使用loop和looped slides之后不会左右轮播，会向左不停轮播你插入的照片。
            paginationClickable: true,
            // 此参数设置为true时，点击分页器的指示点分页器会控制Swiper切换
            spaceBetween: 1,
            // slide之间的距离（单位px）。
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev',
            keyboardControl: true,
            // 是否开启键盘控制Swiper切换。设置为true时，能使用键盘方向键控制slide滑动
            autoplay: 1000,
            // 轮播图的时间。
          });


          $('#mySwiper').swiper({

            slidesPerView: a,
            paginationClickable: true,
            spaceBetween: 30,
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev',
            keyboardControl: true,
            autoplay: 3000

          });
         
        });
        function upload(){
        	let userName = $("#userName").val();
        	let userPhone = $("#userPhone").val();
        	let qustion = $("#qustion").val();
        	let parames = {
        			realname : userName,	
        			phone : userPhone,	
        			question : qustion,	
        	}
      	    if(!userName||!userPhone||!qustion) return alert('请完善信息');
      	    $.ajax({
                url:"<%=basePath%>question/add",
                type:'post',//method请求方式，get或者post
                dataType:'json',//预期服务器返回的数据类型
                data:JSON.stringify(parames),
                contentType: "application/json; charset=utf-8",
                success:function(res){//res为相应体,function为回调函数
                   alert('操作成功')
                 
                },
                error:function(){
                    alert('操作失败！！！');
                }
              });
      	   
        }
        let vm = new Vue({
        	el:'#dataImformation',
        	data(){
        		return {
        			data:[]
        		}
        	},
        	mounted(){
        		 let self = this
        		 $.ajax({
                     url:"<%=basePath%>material/findAll",
                     type:'post',//method请求方式，get或者post
                     dataType:'json',//预期服务器返回的数据类型
                   
                     contentType: "application/json; charset=utf-8",
                     success:function(res){//res为相应体,function为回调函数
                    	
                  	    self.data = res
                  	    
                  	    console.log(self.data)
                     },
                     error:function(){
                      
                     }
                   });
        	}
        })
       
  </script>
</body>
</html>