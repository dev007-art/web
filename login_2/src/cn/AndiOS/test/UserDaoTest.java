package cn.AndiOS.test;

import cn.AndiOS.Dao.UserDao;
import cn.AndiOS.domain.User;
import org.junit.Test;


public class UserDaoTest {
    @Test
    public  void testLogin(){
        User user = new User();
        user.setUsername("mzy");
        user.setPassword("231");
        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        System.out.println(login);

    }
}
