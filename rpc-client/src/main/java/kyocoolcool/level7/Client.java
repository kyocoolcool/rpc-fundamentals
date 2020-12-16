package kyocoolcool.level7;


import kyocoolcool.HelloService;
import kyocoolcool.TeacherService;
import kyocoolcool.User;

/**
 * @author Chris Chen
 * @version 1.0
 * @className Client
 * @description
 * @date 2020/3/19 2:24 PM
 **/

public class Client {
    public static void main(String[] args) throws Exception {
        final HelloService service = (HelloService) Stub.getStub(HelloService.class);
        System.out.println(service.getUser("nick"));
        System.out.println(service.sayHello("good morning"));
        final User user = new User();
        user.setName("night");
        System.out.println(service.saveUser(user));
    }
}
