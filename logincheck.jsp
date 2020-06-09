<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
 <head>
    <title>处理登录页面的数据</title>
 </head>
 <body>
<% 
  request.setCharacterEncoding("UTF-8");
  String name=request.getParameter("loginname");
  String password=request.getParameter("password");
  if(name.equals("张三")&&(password.equals("123456"))){
       session.setAttribute("loginname", name);
       response.sendRedirect("main.jsp");//跳转到主页面
         }else{
             response.sendRedirect("hello.jsp");
         }
  %>
 </body>
</html>