package cn.AndiOS.web.request;
/*
   1.获取请求参数通用的方式
                    1.String getParameter(String name):根据参数名称获取参数值
                    2.String[] getParameterValues(String name):根据参数名称获取参数值的数组 hobby=x&hobby=yy
                    3.Enumeration<String> getParameterNames():获取所有请求的参数名称
                    4.Map<String,String[]> getParameterMap():获取所有参数的map集合
                2.请求转发：
                3.共享数据
                4.获取ServletContext
 */
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo8")
public class requestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo88被访问了");
        //转发到demo9这个资源
  /*      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo9");
        requestDispatcher.forward(request,response);
        */
  //存储数据到request域中
        request.setAttribute("msg","hello");
         request.getRequestDispatcher("/requestDemo9").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/
       this.doPost(request,response);
    }
}
