package cn.Andios.service.impl;

import cn.Andios.dao.UserDao;
import cn.Andios.dao.impl.UserDaoImpl;
import cn.Andios.domain.User;
import cn.Andios.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
}
