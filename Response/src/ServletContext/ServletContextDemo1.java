package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
获取服务器真是路径
 */
@WebServlet("/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*ServletContext对象的获取
         1.通过request对象获取
                    request.getServletContext():
             2.通过HttpServlet
             this.getServletContext()
        */
        //1.通过request对象获取
        ServletContext servletContext = request.getServletContext();

        //2.通过HttpServlet获取
        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext);
        System.out.println("-------------");
        System.out.println(servletContext1);
        System.out.println("------------------");
        System.out.println(servletContext==servletContext1);//true
        //以上两种方法获取的servletContext对象是同一个对象
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
