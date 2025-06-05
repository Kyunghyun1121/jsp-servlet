package org.scoula.dynamicweb.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet 등록 + 매핑 자동화
//@WebServlet(name="MyServlet", urlPatterns={"/xxx", "/yyy"})
public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    System.out.println("HelloServlet 요청");

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head><title>Hello MyServlet</title></head>");
    out.println("<body>");
    out.println("<h1>Hello MyServlet</h1>");
    out.println("현재 시간 : " + LocalDateTime.now().toString());
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public void destroy() {
    System.out.println("destroy 호출");
  }

  @Override
  public void init() throws ServletException {
    System.out.println("init 호출");
  }
}
