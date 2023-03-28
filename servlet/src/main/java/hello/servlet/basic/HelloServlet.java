package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override //서블릿이 호출될 때 service 메서드가 호출되므로 구현 (/hello를 경로를 통해 helloServlet을 사용할때 이 메서드 사용)
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request); // request = org.apache.catalina.connector.RequestFacade@515d825 => WAS 서버들이 구현한 request 구현체
        System.out.println("response = " + response); // response = org.apache.catalina.connector.ResponseFacade@bd226f7 => WAS 서버들이 구현한 response 구현체

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username); // Http 메시지 바디에 메시지가 들어가게 하는 함수



    }
}
