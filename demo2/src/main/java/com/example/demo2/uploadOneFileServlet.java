package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "uploadOneFileServlet", value = "/uploadOneFileServlet")
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
public class uploadOneFileServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("GBK");
    Part part = request.getPart("file");
    String fileDescription = request.getParameter("fileDescription"); // 获取输入的文件描述信息
    out.println("文件描述:"+fileDescription+"<br>");
    File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles")); //设置上传文件路径
    if(!uploadFileDir.exists()){ // 如果文件夹不存在的还创建文件夹
      uploadFileDir.mkdir();
    }
    String realFileName = part.getSubmittedFileName(); // 获取文件名
    out.println("文件名:"+realFileName+"<br>");
    out.println("文件大小:"+part.getSize()+"Byte<br>");
    if(realFileName != null) {
      part.write(uploadFileDir+File.separator+realFileName);
    }
    String realPath = uploadFileDir.getPath(); //获取文件夹的真实路径
    out.println("文件上传到:"+realPath+"<br>");
  }
}
