package kyocoolcool.level7;

import kyocoolcool.HelloService;
import kyocoolcool.User;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/12/16 8:30 PM
 **/
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String content) {
        return "hello rpc";
    }

    @Override
    public String saveUser(User user) {
        System.out.println("save:"+user);
        return "save success";
    }

    @Override
    public User getUser(String name) {
        final User user = new User();
        user.setName(name);
        return user;
    }
}
