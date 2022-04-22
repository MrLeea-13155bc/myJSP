package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getFileServlet", value = "/getFileServlet")
public class getFileServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String fileName = request.getParameter("fileName");
    try {
      System.out.println(fileName);
      response.setHeader("Content-Type","application/x-msdownload");
      response.setHeader("Content-Disposition","attachment;filename="+fileName);
      File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles")); //设置上传文件路径
      FileInputStream in = new FileInputStream(uploadFileDir.getCanonicalPath()+"/"+fileName);
      ServletOutputStream out = response.getOutputStream();
      out.flush();
      int aRead = 0;
      byte b[] = new byte[1024];
      while((aRead = in.read(b)) != -1 & in != null) {
        out.write(b,0,aRead);
      }
      out.flush();
      in.close();
      out.close();
    }catch(Throwable e){
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}
