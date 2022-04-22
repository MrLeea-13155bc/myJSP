<%--
  Created by IntelliJ IDEA.
  User: liyuqi
  Date: 2022/4/14
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>上传多个文件</title>
</head>
<body>
<form action="uploadMultiFilesServlet" method="post" enctype="multipart/form-data">
  <table>
    <tr>
      <td>文件描述1</td>
      <td><input type="text" name="fileDescription1"></td>
    </tr>
    <tr>
      <td>请选择文件1</td>
      <td><input type="file" name="file1"></td>
    </tr>
    <tr>
      <td>文件描述2</td>
      <td><input type="text" name="fileDescription2"></td>
    </tr>
    <tr>
      <td>请选择文件2</td>
      <td><input type="file" name="file2"></td>
    </tr>
    <tr>
      <td align="right"><input type="reset" value="重置"></td>
      <td> <input type="submit" value="上传"></td>
    </tr>
  </table>
</form>
</body>
</html>
