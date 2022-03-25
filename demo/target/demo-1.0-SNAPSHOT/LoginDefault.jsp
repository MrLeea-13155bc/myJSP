<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登陆失败</title>
</head>
<%
  String message;
  message = (String)request.getAttribute("message");
  if(message == null) {
    message = "";
  }
%>
<body>
<h1>登陆失败:<%=message%></h1><br>
<h2 id = "jump">5秒后自动跳转至登陆界面</h2><a href="/">或者点击我</a>
</body>
<script>
  let notice = document.getElementById("jump");
  let count = 4;
  function Count(){
    notice.innerText = count+`秒后自动跳转至登陆界面`;
    count--;
    if(count == 0) {
      window.location = "/"
    }
  };
  window.setInterval("Count()",1000);
</script>
</html>