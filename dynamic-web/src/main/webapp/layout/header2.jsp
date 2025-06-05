<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    String nickName = request.getParameter("nickName");

    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);
%>
안녕하세요 당신의  닉네임은  <%= nickName %>입니다.<br>
현재 시간은  <%= hour %> 시 <%= minute %> 분 <%= second %> 초  입니다.
