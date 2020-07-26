package cn.AndiOS.web.servlet;

import cn.AndiOS.Dao.registDao;
import cn.AndiOS.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = "/registServlet",name="registServlet")
public class registServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User registUser = new User();
        registUser.setUsername(username);
        registUser.setPassword(password);
        registDao registDao = new registDao();
        boolean regist = registDao.regist(registUser);
        if (regist==true){
            request.setAttribute("user",registUser);
            request.getRequestDispatcher("/SuccessRegistServlet").forward(request,response);
        }else{
            request.getRequestDispatcher("/FailRegistServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
