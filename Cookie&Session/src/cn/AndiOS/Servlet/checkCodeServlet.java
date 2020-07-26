package cn.AndiOS.Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//验证码
@WebServlet("/checkCode")
public class checkCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
       //1.创建对象，在内存中图片(验证码图片对象)
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //2.美化图片
        //2.1填充背景色
        Graphics graphics = bufferedImage.getGraphics();//画笔对象
        graphics.setColor(Color.PINK);//设置画笔颜色
        graphics.fillRect(0,0,width,height);
        //2.2画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz1234567890";
        //创建随机角标
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        //2.3画验证码
        for (int i=1;i<4;i++){
            int index = random.nextInt(str.length());
            //获取字符
            char c = str.charAt(index);
            stringBuilder.append(c);
            graphics.drawString(c+"",width/5*i,height/2);
        }
        String checkCode_Session = stringBuilder.toString();
        //将验证码存入Session
        request.getSession().setAttribute("c",checkCode_Session);


        //2.4画干扰线
        graphics.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i=0;i<=5;i++){
            int x1 = random.nextInt(width); int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);int y2 = random.nextInt(height);
            graphics.drawLine(x1,x2,y1,y2);
        }

        //3.将图片输出到页面展示
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
