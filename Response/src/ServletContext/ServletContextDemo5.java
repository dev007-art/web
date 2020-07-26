package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/ServletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
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

        //获取服务器真实路径
        String realPath = c.getRealPath("/c.txt");//web目录下资源访问
        //File file = new File(realPath);
        System.out.println(realPath);
        String realPath1 = c.getRealPath("/WEB-INF/B.txt");//WEB-INF目录下的资源路径
        System.out.println(realPath1);
        String realPath2 = c.getRealPath("/WEB-INF/classes/a.txt");//src下的目录资源路径
        System.out.println(realPath2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
