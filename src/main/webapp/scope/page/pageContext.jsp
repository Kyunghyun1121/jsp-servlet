<%@ page contentType="text/html; charset=UTF-8" %>
<%
  // pageContext를 통해 request 객체 얻기
  HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
  String clientIP = req.getRemoteAddr();

  // pageContext를 통해 session 객체 얻기
  HttpSession sess = pageContext.getSession();
  String sessionId = sess.getId();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>pageContext 예제</title>
</head>
<body>
<p>클라이언트 IP (pageContext 통해): <%= clientIP %></p>
<p>세션 ID (pageContext 통해): <%= sessionId %></p>
</body>
</html>