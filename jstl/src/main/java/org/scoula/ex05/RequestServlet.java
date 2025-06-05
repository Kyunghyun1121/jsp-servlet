package org.scoula.ex05;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setAttribute("username", "홍길동");
    request.setAttribute("useraddress", "서울");

    // RequestDispatcher 요청 발송자
    // 현재 서블릿이 처리중인 요청을 다른 서블릿으로 전달하는 객체이다.
    RequestDispatcher dis = request.getRequestDispatcher("/res.jsp");
    // forward 요청을 위임
    dis.forward(request, response);
  }

}
