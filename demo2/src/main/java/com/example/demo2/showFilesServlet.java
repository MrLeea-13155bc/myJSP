package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "showFilesServlet", value = "/showFilesServlet")
public class showFilesServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("GBK"); //GBK不会出现显示乱码
    PrintWriter out = response.getWriter();
    File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles")); //设置文件夹路径
    if (!uploadFileDir.exists()) {
      uploadFileDir.mkdir();
    }
    File[] array = uploadFileDir.listFiles();
    for(int i=0;i<array.length;i++)
    {
      if(array[i].isFile())//如果是文件
      {
        out.println("<a href='/demo2_war_exploded/getFileServlet?fileName="+array[i].getName()+"'>"+array[i].getName()+"</a><br>");
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}
