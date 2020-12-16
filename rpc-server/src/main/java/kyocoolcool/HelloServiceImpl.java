package kyocoolcool;

import kyocoolcool.level7.Service;

/**
 * @ClassName HelloServiceImpl
 * @Description
 * @Author chris
 * @Date 2019/12/2 2:15 PM
 * @Version 1.0
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String content) {
        return "hello world :" + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("user->" + user);
        return "success";
    }

    @Override
    public User getUser(String name) {
        final User user = new User();
        user.setName(name);
        return user;
    }
}
