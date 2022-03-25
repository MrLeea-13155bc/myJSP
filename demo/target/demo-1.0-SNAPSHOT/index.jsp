<%@ page import="Bean.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
</head>
<body>
<%
  String username,password;
  User user = (User)request.getAttribute("user");
  if(user != null){
     username = user.getUsername();
     password = user.getPassword();
  }else{
    username="";
    password="";
  }
  String msg = (String)request.getAttribute("message");
  if(msg == null){
    msg = "";
  }
%>
<div style="text-align: center;margin-top: 200px">
  <h1>一个登陆系统1231</h1>
  <!-- 一个表单-->
  <form method="post" action="/Login" onsubmit="return CheckForm()">
    账号：<input type="text" name="userName" id = "username" value="<%= username %>"/><br>
    密码：<input type="password" name="password" id="password" value="<%= password %>"/><br>
    <button type="submit" style="margin:20px 0 0 100px">登陆</button>
    <button style="margin:20px 0 0 -100px" onclick="Register()" type="button">注册</button>
    <p id="notice" style="color: red"><%=msg%></p>
  </form>
  <%
    //如果收到错误信息 将输出信息赋给isDefault
    String isDefault = request.getParameter("default");
    if(isDefault == null){
      isDefault="";
    }
  %>
  <!--如果没有isDefault则不会显示-->
  <p style="color: red"><%= isDefault %></p>
</div>
</body>
<script>
  function Register(){
    self.location = "/Register.jsp"
  }
  function CheckForm(){
    let uname = document.getElementById("username").value;
    let upword = document.getElementById("password").value;
    let msg = document.getElementById("notice");
    if(uname == ""){
      msg.innerText = "账号不能为空";
      return false;
    }
    if(upword == ""){
      msg.innerText = "密码不能为空";
      return false;
    }
    return true;
  }
</script>
</html>
