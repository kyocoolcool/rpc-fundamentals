package kyocoolcool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName RemoteInvocationHandler
 * @Description
 * @Author chris
 * @Date 2019/12/2 3:54 PM
 * @Version 1.0
 **/

public class RemoteInvocationHandler implements InvocationHandler {
    String host;
    int port;

    public RemoteInvocationHandler() {
    }

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        final RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
        return rpcNetTransport.sendRequest(rpcRequest);
    }
}
