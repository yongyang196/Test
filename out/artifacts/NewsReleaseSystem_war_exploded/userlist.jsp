<%@ page import="java.util.List" %>
<%@ page import="User.User" %>
<%@ page import="User.UserDemo" %>
<%
    String username= (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<User> userList=null;
    UserDemo userDemo=new UserDemo();
    userDemo.select();
    userList=userDemo.getUserList();
%>
<head>
<meta charset="utf-8">
<meta name="description" content="xxxxx">
<meta name="author" content="xxxxx">
<meta name="keyword" content="xxxxx">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户列表</title>
<!-- start: Css -->
<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">
<!-- plugins -->
<link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
<link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
<link rel="stylesheet" type="text/css" href="asset/css/plugins/fullcalendar.min.css"/>
<link href="asset/css/style.css" rel="stylesheet">
<!-- end: Css -->

</head>

<body id="mimin" class="dashboard">
<!-- start: Header -->
<nav class="navbar navbar-default header navbar-fixed-top">
  <div class="col-md-12 nav-wrapper">
    <div class="navbar-header" style="width:100%;">
      <div class="opener-left-menu is-open"> <span class="top"></span> <span class="middle"></span> <span class="bottom"></span> </div>
      <a href="index.jsp" class="navbar-brand"> <b>返回首页</b> </a>
      <ul class="nav navbar-nav navbar-right user-nav">
        <li class="user-name"><span><%=username%></span></li>
        <li class="dropdown avatar-dropdown"> <img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
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
        <li class="ripple"> <a class="tree-toggle nav-header" id="left-menu-1"><a href="index.jsp"><span class="fa-home fa"></span> 首页 <span class="fa-angle-right fa right-arrow text-right"></span></a> </a> </li>
        <li class="ripple active"> 
          <a class="tree-toggle nav-header"  id="left-menu-2"> <span class="fa-diamond fa"></span> 用户管理 
            <span class="fa-angle-right fa right-arrow text-right"></span> </a>
          <ul class="nav nav-list tree" >
            <li><a href="userlist.jsp">用户列表</a></li>
            <%--<li><a href="useredit.jsp">信息编辑</a></li>--%>
          </ul>
        </li>
        <li class=" ripple"> 
          <a class="tree-toggle nav-header"  id="left-menu-3"><span class="fa fa-check-square-o"></span> 新闻管理 
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
        <div class="col-md-12">
          <h3 class="animated fadeInLeft">用户列表</h3>
          <p class="animated fadeInDown"> 业务 <span class="fa-angle-right fa"></span> 用户列表 </p>
        </div>
      </div>
    </div>
    <div class="col-md-12 padding-0 form-element">
      <div class="col-md-12">
       <div class="panel form-element-padding">
            
        <div class="panel">
          <div class="panel-heading">
            <h3>列表名称</h3>
          </div>
          <div class="panel-body">
            <div class="responsive-table">
              <div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                <div class="row">
                  <div class="col-sm-12">
                    <table class="table table-striped table-bordered dataTable no-footer" width="100%" cellspacing="0"  style="width: 100%;">
                      <thead>
                        <tr role="row">
                          <th class="sorting_asc" style="width: 60px;">用户名</th>
                          <th class="sorting" style="width: 60px;">密码</th>
                          <th class="sorting" style="width: 60px;">性别</th>
                          <th class="sorting" style="width: 60px;">身份权限</th>
                          <th class="sorting"  style="width: 60px;">手机号</th>
                          <th class="sorting"  style="width: 61px;">编辑</th>
                        </tr>
                      </thead>
                      <tbody>
                        <%--<tr role="row" class="odd">--%>
                          <%--<td class="sorting_1">Airi Satou</td>--%>
                          <%--<td>Accountant</td>--%>
                          <%--<td>Tokyo</td>--%>
                          <%--<td>33</td>--%>
                          <%--<td>2008/11/28</td>--%>
                          <%--<td>$162,700</td>--%>
                            <%
                                for (User user:userList){%>
                                <tr role="row" class="odd">
                                    <td class="sorting_1"><%=user.getUsername()%></td>
                                    <td><%=user.getUserpwd()%></td>
                                    <td><%=user.getUsersex()%></td>
                                    <%if (user.getUserlevel().equals("0")){%>
                                        <td>管理员</td>
                                    <%}
                                    else{%>
                                        <td>普通用户</td>
                                    <%}%>
                                    <td><%=user.getUsertel()%></td>
                                    <td><a href="useredit.jsp?name=<%=user.getUserid()%>">编辑</a></td>
                                </tr>
                                <%}
                            %>
                      </tbody>
                    </table>
                  </div>
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
<script>
$("#left-menu-2").click() ;
</script>

</body>

</html>