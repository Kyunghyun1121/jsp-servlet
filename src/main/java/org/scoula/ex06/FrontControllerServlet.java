package org.scoula.ex06;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.scoula.ex06.command.Command;
import org.scoula.ex06.controller.HomeController;
import org.scoula.ex06.controller.TodoController;

// value = "/" 모든 요청을 해당 서블릿에 매핑시키겠다는 의미
// /test, /board 같은 요청이 왔을 때 해당 servlet이 없으면 /로 온다.
@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends HttpServlet {
  // URL과 Command 매핑을 저장하는 Map
  Map<String, Command> getMap;
  Map<String, Command> postMap;

  // View Resolver 설정
  // - forward 요청 시 JSP 경로를 나타낼 접두사/접미사
  String prefix = "/WEB-INF/views/";
  String suffix = ".jsp";

  HomeController homeController = new HomeController();
  TodoController todoController = new TodoController();

  // 서블릿 객체 생성 시 실행되는 init() 메서드
  public void init() {
    getMap = new HashMap<>();
    postMap = new HashMap<>();

    // 🏠 메인 페이지 요청
    getMap.put("/", homeController::getIndex);

    // GET 매핑
    getMap.put("/todo/list", todoController::getList);
//    getMap.put((response, request) -> return "/todo/list")이거랑 동일하다.

    getMap.put("/todo/view", todoController::getView);
    getMap.put("/todo/create", todoController::getCreate);
    getMap.put("/todo/update", todoController::getUpdate);

    // POST 매핑
    postMap.put("/todo/create", todoController::postCreate);
    postMap.put("/todo/update", todoController::postUpdate);
    postMap.put("/todo/delete", todoController::postDelete);
  }

  // URI 식별 값 추출 메소드
  private String getCommandName(HttpServletRequest req) {
    String requestURI = req.getRequestURI(); // 전체 URI 반환
    String contextPath = req.getContextPath(); // context 경로 반환
    return requestURI.substring(contextPath.length());
  }

  // Map 에서 요청 URL 과 일치하는 Command 를 조회하는 메소드
  private Command getCommand(HttpServletRequest req) {
    String commandName = getCommandName(req);
    Command command;

    // Get 방식인지 Post 방식인지 추출해준다.
    if(req.getMethod().equalsIgnoreCase("GET")) {
      command = getMap.get(commandName);
    } else {
      command = postMap.get(commandName);
    }
    return command;
  }

  //Command 실행 및 view 연결 처리
  public void execute(Command command, HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    // Command를 실행하여 View 이름 얻어오기
    String viewName = command.execute(req, resp);

    // 얻어온 View 이름이 "redirect:"로 시작하는 경우 Redirect
    // redirect 는 부조건 Get 방식으로 받는다.
    if(viewName.startsWith("redirect:")) { // redirect 처리
      resp.sendRedirect(viewName.substring("redirect:".length()));
    }
    // 나머지 경우는 접두사/접미사를 붙여 JSP로 Forward
    else { // forward 처리
      String view = prefix + viewName + suffix;
      RequestDispatcher dis = req.getRequestDispatcher(view);
      dis.forward(req, resp);
    }
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {
    Command command = getCommand(req);

    if(command != null) {
      execute(command, req, resp);
    } else { // 404 에러 처리
      String view = prefix + "404" + suffix;
      RequestDispatcher dis = req.getRequestDispatcher(view);
      dis.forward(req, resp);
    }
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);  // GET과 동일한 처리 로직 사용
  }


}
