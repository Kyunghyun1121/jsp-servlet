<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Servlet-JSP 학습 예제</title>
    <meta charset="UTF-8">
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 40px;
        background-color: #f5f5f5;
      }
      .container {
        background-color: white;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        max-width: 800px;
        margin: 0 auto;
      }
      h1 {
        color: #333;
        text-align: center;
        border-bottom: 3px solid #007bff;
        padding-bottom: 10px;
      }
      ol {
        font-size: 16px;
        line-height: 2;
      }
      li {
        margin-bottom: 10px;
        padding: 8px;
        background-color: #f8f9fa;
        border-radius: 4px;
      }
      a {
        text-decoration: none;
        color: #007bff;
        font-weight: bold;
      }
      a:hover {
        color: #0056b3;
        text-decoration: underline;
      }
      .description {
        color: #666;
        font-size: 14px;
        margin-left: 10px;
      }
    </style>
</head>
<body>
<div class="container">
    <h1>🚀 Servlet-JSP 예제 목록</h1>

    <ol>
        <li>
            <a href="request">Request Forwarding</a>
            <span class="description">Request 객체 속성 설정 및 Forward</span>
        </li>
        <li>
            <a href="request_redirect">Request Redirect</a>
            <span class="description">속성 설정 후 리다이렉트 (데이터 손실 확인)</span>
            <ol>
                <li>/request_redirect 요청</li>
                <li>/response_redirect 리다이렉트 확인</li>
            </ol>
        </li>
        <li>
            <a href="/login.jsp">EL 기초</a>
            <span class="description">Request 세팅 속성 값 EL로 출력 확인</span>
        </li>
        <li>
            <a href="scope">Scope 테스트</a>
            <span class="description">Page, Request, Session, Application Scope 비교</span>
        </li>
        <li>
            <a href="el_example?id=testuser&pass=1234&address=서울시&address=광진구">EL 객체, 연산자 예제</a>
            <span class="description">EL을 이용한 파라미터 얻어오기, 연산자 사용법</span>
        </li>
        <li>
            <a href="jstl_ex">JSTL 예제</a>
            <span class="description">JSTL 태그 라이브러리 활용 및 컬렉션 처리</span>
        </li>
    </ol>

</div>
</body>
</html>