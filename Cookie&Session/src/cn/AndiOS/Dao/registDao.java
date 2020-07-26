package cn.AndiOS.Dao;

import cn.AndiOS.domain.User;
import cn.AndiOS.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class registDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtil.getDs());
    public boolean regist(User registUser){
        String sql="insert into user values(?,?,?)";
        int result = template.update(sql,new Object[]{registUser.getId(),registUser.getUsername(),registUser.getPassword()});
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}
