package kyocoolcool;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final HelloServiceImpl helloService = new HelloServiceImpl();
        final RpcServerProxy rpcServerProxy = new RpcServerProxy();
        rpcServerProxy.publisher(helloService, 8080);
    }
}
