<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h3>로그인 정보 보기</h3>
<%
    String id = (String) session.getAttribute("userid");
    if (id == null) {
        out.print("로그인이 되어있지 않습니다");

    } else {
        String pw = (String) session.getAttribute("password");
        out.print("사용자 아이디값: " + id + "<br>");
        out.print("사용자 비밀번호값: " + pw + "<br>");
    }
%>
