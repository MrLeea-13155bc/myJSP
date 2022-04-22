package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "uploadMultiFilesServlet", value = "/uploadMultiFilesServlet")
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
public class uploadMultiFilesServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int count = 0;
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("utf-8");
    File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles")); //设置上传文件路径
    if (!uploadFileDir.exists()) { // 如果文件夹不存在的还创建文件夹
      uploadFileDir.mkdir();
    }
    for (int i = 1; i <= 2; i++) {
      Part part = request.getPart("file" + i);
      String fileDescription = request.getParameter("fileDescription" + i); // 获取输入的文件描述信息
      String realFileName = part.getSubmittedFileName(); // 获取文件名
      if (!fileDescription.isEmpty() || realFileName != "") {
        count++;
        out.println("文件描述:" + fileDescription + "<br>");
        part.write(uploadFileDir + File.separator + realFileName);
        out.println("文件名:" + realFileName + "<br>");
        out.println("文件大小:" + part.getSize() + "Byte<br>");
        String realPath = uploadFileDir.getPath(); //获取文件夹的真实路径
        out.println("文件上传到:" + realPath + "<br>");
      }
    }
    if(count == 0) {
      out.println("啥也没有<br>");
    }
  }
}

