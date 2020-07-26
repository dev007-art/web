package cn.Andios.test;

import cn.Andios.dao.impl.UserDaoImpl;
import cn.Andios.util.JDBCUtil;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class daotest {
    @Test
    public void tets(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDs());
        System.out.println(template);
    }
}
