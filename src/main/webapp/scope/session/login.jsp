<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 25. 1. 10.
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 정보 세션 저장</h1>
<%
    String id = request.getParameter("userid");
    if (id == null) {
        response.sendRedirect("loginForm.html");
    } else {
        String pw = request.getParameter("password");
        session.setAttribute("userid", id);
        session.setAttribute("password", pw);
        response.sendRedirect("/");
    }
%>
</body>

</html>
