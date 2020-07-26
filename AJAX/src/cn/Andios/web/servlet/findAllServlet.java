package cn.Andios.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findAllServlet")
public class findAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        //1.获取用户名
        String username = request.getParameter("username");
        //2.调用servic层判断用户名是否存在
        Map<String,Object> map= new HashMap<>();
        if("tom".equals(username)){
           map.put("userExsit",true);
            map.put("msg","此用户太受欢迎，请换一个");
        }else {
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }//将map转为json，并传递到客户端
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
