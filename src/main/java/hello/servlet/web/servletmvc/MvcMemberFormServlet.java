package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet",urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        //  컨트롤러에서 뷰로 이동할때 아래 방법 잉요
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // servlet에서 jsp 호출할때 사용
        //      서버안에서 method 호출하듯이 이동하는거라서 주소가 변경되지 않음
                    //리다이렉트는 호출 자체가 2번 이루어지며 다시 이동하는걸 클라이언트가 인지도 가능하고 url도 바뀜
                    // forward 사용시 서버내에서 일어나는 호출이라 클라이언트가 인지하지 못하고 url도 그대로임
        //      web-inf 안에 있으면 외부에서 직접 부르지 못하고 컨트롤러 거쳐서만 불러짐
        dispatcher.forward(request,response);
    }
}
