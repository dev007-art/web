package cn.AndiOS.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用Durid连接池
 */
public class JDBCUtil {
    private static DataSource ds;
    /**
     *获取连接池对象
     */
    static{
        //1.加载配置文件
        try {
            Properties pro = new Properties();
            //使用ClassLoad加载配置文件获取字节输入流
            InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(resourceAsStream);

            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
           e.printStackTrace();
        }  finally{
        }

    }
    public static DataSource getDs(){
        return  ds;
    }
    /**
     * 获取连接池对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
