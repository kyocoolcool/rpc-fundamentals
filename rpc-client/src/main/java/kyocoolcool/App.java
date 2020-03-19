package kyocoolcool;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy();
        final HelloService helloService = proxy.clientProxy(HelloService.class, "localhost", 8080);
        final User user = new User();
        user.setName("ALiBaBa");
        System.out.println(helloService.saveUser(user));
    }
}
