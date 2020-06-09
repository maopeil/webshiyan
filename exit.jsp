<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
   <head>
      <title>退出系统</title>
   </head>
   <body>
     <%
        session.invalidate();
        response.sendRedirect("hello.jsp");
      %>
   </body>
</html>