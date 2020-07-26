package cn.AndiOS.web.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1。创建真实对象
        Lenove lenove = new Lenove();
        //2.动态代理增强lenove对象
        /*
        三个参数：
                 1.类加载器：真实对象.getClass().getClassLoader()
                 2.接口数组：真实对象.getClass().getInterfaces()
                 3.处理器：new InvocationHandler()
         */
        SaleComputer proxy_Lenovo =(SaleComputer)Proxy.newProxyInstance(lenove.getClass().getClassLoader(), lenove.getClass().getInterfaces(), new InvocationHandler() {
            /*
            代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                         1.proxy:代理对象
                         2.method:代理对象调用的方法，被封装为的对象
                         3.args:方法执行时，传递的时间参数
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
           /*     System.out.println("该方法执行了");
                System.out.println(method.getName());
                System.out.println(args[0]);*/

           //判断是否为sale方法
           if (method.getName().equals("sale")){
               //1.增强参数
               double money=(double)args[0];
               money=money*0.85;
               String invoke = (String) method.invoke(lenove, money);
               return invoke+"+鼠标垫";
           }else{
               //使用真实对象调用该方法
               Object obj = method.invoke(lenove,args);
               return  obj;
           }

            }
        });
     String sale = proxy_Lenovo.sale(80000);
        System.out.println(sale);
         /* proxy_Lenovo.show();*/
    }

}



