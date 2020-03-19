package kyocoolcool;


import java.lang.reflect.Proxy;

/**
 * @ClassName RpcClientProxy
 * @Description 動態代理
 * @Author chris
 * @Date 2019/12/2 3:47 PM
 * @Version 1.0
 **/
//動態代理:java原生的proxy/cglib/javassit/asm
public class RpcClientProxy {
    public <T> T clientProxy(Class<T> interfaceCls, String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}