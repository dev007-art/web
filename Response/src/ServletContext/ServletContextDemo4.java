package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        ServletContext功能:
         1.获取MIME类型:
                *MIME类型:在互联网通信过程中定义的一种文件数据类型
                *格式:大类型/小类型    text/html    image/jpeg
                *获取：String getMimeType(String file	)
               2.域对象：共享数据
               3.获取文件的真实(服务器 )路径
         */
        //2.通过HttpServlet获取
        ServletContext c = this.getServletContext();

        //获取数据
        Object msg = c.getAttribute("msg");
        System.out.println(msg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
