package org.scoula.ex06.command;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Command {
  String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException;
}
