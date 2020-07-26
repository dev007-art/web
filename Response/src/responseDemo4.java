import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/*
字符输出流
 */
@WebServlet("/responseDemo4")
public class responseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置默认编码：ISO-8859-1 设置为GBK
        //response.setCharacterEncoding("utf-8");

        //告诉浏览器，服务器发送的消息体数据的编码，建议使用该编码解码
       // response.setHeader("content-type","text/html;charset=utf-8");

        //简单的形式，设置编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        //tomcat创建的response对象,使用的编码是ISO-8859-1
        PrintWriter writer = response.getWriter();
        //2.输出数据
        //writer.write("<h1>hello response</h1>");
        writer.write("你好");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
