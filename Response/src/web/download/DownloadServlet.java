package web.download;

import web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String filename = request.getParameter("filename");

        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器真实路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        System.out.println(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型:content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);

        //3.2解决中文文件名问题
        //3.2.1获取user-agent请求头
        //3.2.2使用工具类编码文件名
        String agent = request.getHeader("user-agent");
        String fileName = DownLoadUtils.getFileName(agent, filename);
        //3.3设置响应头打开方式:content-disposition
        response.setHeader("content-disposition","attachment;filename="+fileName);

        //4.将输入流的数据写出到输出流
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len=0;
        while ((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
