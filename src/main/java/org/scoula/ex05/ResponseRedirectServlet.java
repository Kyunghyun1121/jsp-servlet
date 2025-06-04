package org.scoula.ex05;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response_redirect")
public class ResponseRedirectServlet extends HttpServlet {

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    String username = (String) req.getAttribute("username");
    String useraddress = (String) req.getAttribute("useraddress");

    //속성 설정
    //현재 서블릿의 req 객체는 새로 만들어진 요청 객체
    req.setAttribute("username", username);
    req.setAttribute("useraddress", useraddress);

    //forward
    RequestDispatcher dis = req.getRequestDispatcher("/redirect_res.jsp");
    dis.forward(req, res);
  }

}