package kyocoolcool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName RpcServerProxy
 * @Description 動態代理
 * @Author chris
 * @Date 2019/12/2 2:17 PM
 * @Version 1.0
 **/

public class RpcServerProxy {
    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object service, int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept(); //接收一個請求(bio)
                executorService.execute(new ProcessorHandler(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}