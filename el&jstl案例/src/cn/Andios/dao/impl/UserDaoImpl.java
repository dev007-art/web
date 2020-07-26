package cn.Andios.dao.impl;

import cn.Andios.dao.UserDao;
import cn.Andios.domain.User;
import cn.Andios.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDs());
    public List<User> findAll() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
