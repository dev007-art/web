import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问/responseDemo1，会自动跳转/responseDemo2资源
        //1.设置状态码302
      /*  System.out.println("demo1......");
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/responseDemo2");
        //简单的重定向方法*/
        String contextPath = request.getContextPath();
        request.setAttribute("msg","response");
        response.sendRedirect(contextPath+"/responseDemo2");
        //response.sendRedirect("http://www.baidu.cn");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
