<%@ page import="News.NewsDemo" %>
<%@ page import="News.News" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username= (String) session.getAttribute("username");
    String userlevel= (String) application.getAttribute("level");
%>


<%
    NewsDemo newsDemo=new NewsDemo();
    newsDemo.select();
    List<News> newsList=null;
    newsList=newsDemo.getNewsList();
%>

<head>
<meta charset="utf-8">
<meta name="description" content="12">
<meta name="author" content="12">
<meta name="keyword" content="12">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>首页</title>

<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
<link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
<link rel="stylesheet" type="text/css" href="asset/css/plugins/fullcalendar.min.css"/>
<link href="asset/css/style.css" rel="stylesheet">
</head>

<body id="mimin" class="dashboard">
<!-- start: Header -->
<nav class="navbar navbar-default header navbar-fixed-top">
  <div class="col-md-12 nav-wrapper">
    <div class="navbar-header" style="width:100%;">
      <div class="opener-left-menu is-open"> 
        <span class="top"></span> 
        <span class="middle"></span> 
        <span class="bottom"></span> 
      </div>
      <a href="index.jsp" class="navbar-brand"> <b>首页</b> </a>
      <ul class="nav navbar-nav navbar-right user-nav">
        <li class="user-name"><span><%=username%></span></li>
        <li class="dropdown avatar-dropdown">
            <img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
          <ul class="dropdown-menu user-dropdown">
              <li><a href="#"><p value="<%=username%>" id="backli" onclick="back()"><span class="fa fa-power-off"></span> 退出登录</p></a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<!-- end: Header -->
<div class="container-fluid mimin-wrapper"> 
  <!-- start:Left Menu -->
  <div id="left-menu">
    <div class="sub-left-menu scroll">
      <ul class="nav nav-list">
        <li>
          <div class="left-bg"></div>
        </li>
        <li class="active ripple"> 
          <a class="tree-toggle nav-header"><span class="fa-home fa"></span> 首页
              <span class="fa-angle-right fa right-arrow text-right"></span>
          </a>
        </li>
        <li class="ripple">
          <a class="tree-toggle nav-header"><p id="leveljudge" value="<%=userlevel%>" onclick="leveljudge()"> <span class="fa-diamond fa"></span> 用户管理
              <span class="fa-angle-right fa right-arrow text-right"></span> </p>
          </a>
          <ul class="nav nav-list tree">
            <li id="leveljudge1"><a href="userlist.jsp">用户列表</a></li>
            <%--<li><a href="useredit.jsp">信息编辑</a></li>--%>
          </ul>
        </li>
        <li class="ripple"> 
          <a class="tree-toggle nav-header"><span class="fa fa-check-square-o"></span> 新闻管理 
            <span class="fa-angle-right fa right-arrow text-right"></span> 
          </a> 
          <ul class="nav nav-list tree">
              <li><a href="newslist.jsp">新闻列表</a></li>
              <%--<li><a href="newsitem.jsp">新闻详情</a></li>--%>
              <li><a href="newsupload.jsp">发表新闻</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <!-- end: Left Menu -->
  <!-- start: content -->
  <div id="content">
    <div class="panel">
      <div class="panel-body">
        <div class="col-md-6 col-sm-12">
          <h3 class="animated fadeInLeft">欢迎您：<%=username%></h3>
          <p class="animated fadeInDown"><span class="fa  fa-map-marker"></span> 首页</p>
        </div>
      </div>
    </div>
    <div class="col-md-12" style="padding:20px;">
      <div class="col-md-12 padding-0">
        <div class="col-md-8 padding-0">
          <div class="col-md-12 padding-0">
            <div class="col-md-6">
              <div class="panel box-v1">
                <div class="panel-heading bg-white border-none">
                  <div class="col-md-6 col-sm-6 col-xs-6 text-left padding-0">
                    <h4 class="text-left">最新新闻</h4>
                  </div>
                  <div class="col-md-6 col-sm-6 col-xs-6 text-right">
                    <h4> <span class="icon-user icons icon text-right"></span> </h4>
                  </div>
                </div>
                <div class="panel-body text-center">
                  <ul class="normal-list">
                      <%for (News news:newsList){%>
                      <li class="text-left"><span class="right"><%=news.getNewsdate()%></span><a href="newsitem.jsp?newsid=<%=news.getNewsid()%>"><span class="fa fa-angle-right"></span> <%=news.getNewsitem()%></a></li>
                      <%}%>
                  </ul>
                  <p><a href="#">更多信息</a></p>
                  <hr/>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="panel box-v1">
                <div class="panel-heading bg-white border-none">
                  <div class="col-md-6 col-sm-6 col-xs-6 text-left padding-0">
                    <h4 class="text-left">热论新闻</h4>
                  </div>
                  <div class="col-md-6 col-sm-6 col-xs-6 text-right">
                    <h4> <span class="icon-check icons icon text-right"></span> </h4>
                  </div>
                </div>
                <div class="panel-body text-center">
                  <ul class="normal-list">
                      <%for (News news:newsList){%>
                      <li class="text-left"><span class="right"><%=news.getNewsdate()%></span><a href="newsitem.jsp?newsid=<%=news.getNewsid()%>"><span class="fa fa-angle-right"></span> <%=news.getNewsitem()%></a></li>
                      <%}%>
                  </ul>
                  <p><a href="#">更多信息</a></p>
                  <hr/>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="col-md-12 padding-0">
            <div class="panel box-v2">
              <div class="panel-heading padding-0"> <img src="asset/img/bg2.jpg" class="box-v2-cover img-responsive"/>
                <div class="box-v2-detail"> <img src="asset/img/avatar.jpg" class="img-responsive"/>
                  <h4><%=username%></h4>
                </div>
              </div>
              <div class="panel-body">
                <div class="col-md-12 padding-0 text-center">
                  <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                    <h3>2000</h3>
                    <p>已发布新闻</p>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                    <h3>1000</h3>
                    <p>粉丝</p>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                    <h3>1000</h3>
                    <p>评论数</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end: content -->
</div>
<!-- start: Javascript --> 
<script src="asset/js/jquery.min.js"></script> 
<script src="asset/js/jquery.ui.min.js"></script> 
<script src="asset/js/bootstrap.min.js"></script> 
<!-- plugins --> 
<script src="asset/js/plugins/jquery.nicescroll.js"></script> 
<!-- custom --> 
<script src="asset/js/main.js"></script>
<script src="asset/js/moment.js"></script>
<script src="js/Confim.js"></script>
<!-- end: Javascript -->
</body>
</html>