package org.scoula.dynamicweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ResponseServlet", urlPatterns = "/response")
public class ResponseServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");

    // Hello
    PrintWriter out = resp.getWriter();
    out.println("<html><body>");
    out.println("<h1>ResponseServlet 요청 성공</h1>");
    out.println("</body></html>");
  }
}
