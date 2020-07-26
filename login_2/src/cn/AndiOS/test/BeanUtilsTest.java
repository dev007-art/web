package cn.AndiOS.test;

import cn.AndiOS.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user =new User();
        try {
            BeanUtils.setProperty(user,"username","zs");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //System.out.println(user);
        String username = BeanUtils.getProperty(user, "username");
        System.out.println(username);
    }
}
