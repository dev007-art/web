package cn.Andios.web.test;

import cn.Andios.web.domian.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {
    //java对象转为jason字符串
    @Test
    public void test1() throws IOException {
        //1.创建person对象
        Person p = new Person();
        p.setAge(12);
        p.setGender("nan");
        p.setName("zs");

        //2.创建jackson核心对象
        ObjectMapper objectMapper = new ObjectMapper();
        //3.转换obj
        /**
         * 转换方法
         * writeValue(参数一,obj)
         *    参数一：
         *          File:将obj对象转换为JSON字符串，并保到指定文件中
         *          Write：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
         *          outPutStream:将obj对象转换为
         * writeAsString(obj):将对象转为json对象
         */
        String s = objectMapper.writeValueAsString(p);
        System.out.println(s);//{"name":"zs","gender":"nan","age":12}


        //writeValue方法,将数据写到d://a.txt文件中
        /*objectMapper.writeValue(new File("d://a.txt"),p);*/
        //writeValue，将数据关联到write中
        objectMapper.writeValue(new FileWriter("d://b.txt"),p);
    }

    @Test
    public void test2() throws JsonProcessingException {
        Person p = new Person();
        p.setAge(12);
        p.setGender("nan");
        p.setName("zs");
        p.setBirthday(new Date());
        //转换
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(p);
        System.out.println(s);////{"name":"zs","gender":"nan","age":12,"birthday":1595651513215}

    }
    @Test
    public void test3() throws JsonProcessingException {
        Person p1 = new Person();
        p1.setAge(12);
        p1.setGender("nan");
        p1.setName("zs");
        p1.setBirthday(new Date());
        Person p2 = new Person();
        p2.setAge(12);
        p2.setGender("nan");
        p2.setName("zs");
        p2.setBirthday(new Date());
        Person p = new Person();
        p.setAge(12);
        p.setGender("nan");
        p.setName("zs");
        p.setBirthday(new Date());
        //创建List集合
        List<Person> ps= new ArrayList<>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);
        //转换
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(ps);
        System.out.println(s);//[{"name":"zs","gender":"nan","age":12,"birthday":"2020-07-25"},{"name":"zs","gender":"nan","age":12,"birthday":"2020-07-25"},{"name":"zs","gender":"nan","age":12,"birthday":"2020-07-25"}]

    }
}
