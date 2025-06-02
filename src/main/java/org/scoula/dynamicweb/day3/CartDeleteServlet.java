package org.scoula.dynamicweb.day3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart_delete")
public class CartDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=utf-8");

    PrintWriter out = response.getWriter();
    out.print("<html><body>");
    out.print("장바구니  비웟음!!");

    HttpSession session = request.getSession(false);
    if(session != null) {
      session.invalidate();
    }else{
      out.print("세션 없음" + "<br>");
    }

    out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
    out.print("<body></html>");

  }

}
