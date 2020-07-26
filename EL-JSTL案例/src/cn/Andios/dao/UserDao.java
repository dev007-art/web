package cn.Andios.dao;

import cn.Andios.domain.User;

import java.util.List;

/**
 * 用户操作Dao
 */
public interface UserDao {
    public List<User> findAll();
}
