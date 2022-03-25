<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登陆界面</title>
</head>
<body>
<div style="text-align: center;margin-top: 200px;line-height: 30px">
  <h1>一个注册界面</h1>
  <form id="form" onsubmit="return Register()" action="/Register" method="post">
    <table style="margin: 0 auto">
      <tr style="text-align:right;">
        <td>账号:</td>
        <td><input type="text" id="username" name="username" class="input"></td>
      </tr>
      <tr>
        <td style="text-align:right;">密码:</td>
        <td><input type="password" id ="password" name="password" class="input"></td>
      </tr>
      <tr>
        <td style="text-align:right;">确认密码:</td>
        <td><input type="password" id="confirm" name="confirm-password" class="input"></td>
      </tr>
    </table>
    <button type="submit" style="margin:20px 0 0 100px">注册</button>
    <button style="margin:20px 0 0 -100px" onclick="Return()" type="button">返回</button>
    <p id="notice" style="color: red"></p>
  </form>
</div>
</body>
<script>
  function Return(){
    self.location = "/";
  }
  function Register(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let confirm = document.getElementById("confirm").value;
    let notice = document.getElementById("notice");
    if (username == ""){
      notice.innerText = "账号不能为空";
      return false;
    }
    if (password == "") {
      notice.innerText = "密码不能为空";
      return false;
    }
    if (password != confirm){
      notice.innerText = "两次密码不同";
      return false;
    }
    return true;
  }
</script>
</html>
