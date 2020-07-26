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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo6")
public class requestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取post请求参数
        //1.String getParameter(String name):根据参数名称获取参数值
        String username = request.getParameter("username");
    /*    System.out.println("post");
        System.out.println(username);*/
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby:hobbies) {
            System.out.println(hobby);

        }
        Enumeration<String> parameterNames = request.getParameterNames();
      /*  while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s);
            String[] parameter = request.getParameterValues(s);
            System.out.println(parameter[0]);
            System.out.println("------");
        }*/
      //获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> strings = parameterMap.keySet();
        for (String key:strings
             ) {
            //根据key获取值
            String[] strings1 = parameterMap.get(key);
            System.out.println(key);
            for (String value:strings1
                 ) {
                System.out.println(value);
                System.out.println("-------");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/
       this.doPost(request,response);
    }
}
