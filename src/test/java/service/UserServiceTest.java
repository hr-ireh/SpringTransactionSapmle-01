package service;


import ir.hri.entities.User;
import ir.hri.service.UserService;
import ir.hri.util.SpringUtil;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Test()
    public void stage1_insertUserTest() {
        UserService userService = (UserService) SpringUtil.getApplicationContext().getBean("userServiceImpl");
        User user = new User();
        user.setFirsName("AmirAli");
        user.setLastName("Nori");
        user.setUsername("AAN");
        userService.insertUser(user);
    }

    @Test
    public void stage2_getUserTest() {
        UserService userService = (UserService) SpringUtil.getApplicationContext().getBean("userServiceImpl");
        Assert.assertNotNull(userService.getUser("AAN"));
    }

    @Test
    public void stage3_getUsersTest() {
        UserService userService = (UserService) SpringUtil.getApplicationContext().getBean("userServiceImpl");
        Assert.assertEquals(1, userService.getUsers().size());
    }
}
