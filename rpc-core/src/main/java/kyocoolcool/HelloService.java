package kyocoolcool;

public interface HelloService {
    String sayHello(String content);
    String saveUser(User user);
    User getUser(String name);
}
