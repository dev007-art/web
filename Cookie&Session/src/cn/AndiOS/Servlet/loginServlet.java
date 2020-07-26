package cn.AndiOS.Servlet;

import cn.AndiOS.Dao.UserDao;
import cn.AndiOS.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置request编码
        request.setCharacterEncoding("UTF-8");
        //2.获取参数map
        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser =new User();
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserDao Dao = new UserDao();
        User login = Dao.login(loginUser);
        String checkCode = request.getParameter("checkCode");

        //3.获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("c");
        //删除session中储存的验证码
        session.removeAttribute("c");
        //3.判断验证码是否正确
        if(checkCode_session!=null&&checkCode_session.equalsIgnoreCase(checkCode)) {//忽略大小写比较
            //判断用户名或者密码是否一致
            if(login!=null){
                //登录成功
                //存储用户信息
                session.setAttribute("user",loginUser.getUsername());
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                //存储提示信息到request
                request.setAttribute("login_error","用户名或密码错误");
                //2.转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else {
            //验证码不一样            //存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            //2.转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
