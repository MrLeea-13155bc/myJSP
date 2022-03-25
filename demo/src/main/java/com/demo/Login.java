package com.demo;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("userName");
    String passWord = req.getParameter("password");
    String right = QueryPassword(userName);
    if(passWord.equals(right)){
      resp.sendRedirect("/Welcome.jsp");
      return;
    }
    if(right == "404"){
      right = "账户不存在";
    }else if(right == "500"){
      right = "数据库发生异常";
    }else{
      right = "密码错误";
    }
    req.setAttribute("message",right);
    req.getRequestDispatcher("/LoginDefault.jsp").forward(req, resp);
  }
  protected String QueryPassword(String username){
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    String msg="";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSP","root","liyuqi521");
      ps = con.prepareStatement("Select Password From User Where Username='"+ username+"';");
      rs = ps.executeQuery();
      while(rs.next()){
        msg = rs.getString(1);
      }
    }catch (Exception e) {
      msg =  "500";
    }
    if(msg == ""){
      msg =  "404";
    }
    try{
      rs.close();
      ps.close();
      con.close();
    }catch(Exception e){

    }
    return msg;
  }
}
