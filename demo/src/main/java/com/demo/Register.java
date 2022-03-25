package com.demo;

import Bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.beans.Beans;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user = new User();
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    user.setUsername(username);
    user.setPassword(password);
    int ok = Register(username,password);
    String msg;
    if (ok == 1) {
      req.setAttribute("message","注册成功");
      req.getRequestDispatcher("/").forward(req, resp);
    }else{
      msg = "该账号已存在";
      req.setAttribute("message",msg);
      req.getRequestDispatcher("/RegisterDefault.jsp").forward(req, resp);
    }
  }

  protected int Register(String username,String password){
    Connection con=null;
    PreparedStatement ps=null;
    int rs = 0;
    String msg="";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSP","root","liyuqi521");
      String sql = "Insert Into User(Username,Password) values(?,?)";
      ps = con.prepareStatement(sql);
      ps.setString(1,username);
      ps.setString(2,password);
      rs = ps.executeUpdate();
    }catch (Exception e) {
      rs =  500;
    }
    try{
      ps.close();
      con.close();
    }catch(Exception e){

    }
    return rs;
  }
}
