package kyocoolcool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @ClassName RpcNetTransport
 * @Description
 * @Author chris
 * @Date 2019/12/2 3:57 PM
 * @Version 1.0
 **/

public class RpcNetTransport {
    String host;
    int port;

    public RpcNetTransport() {
    }

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket() {
        System.out.println("創建一個新的socket連接");
        Socket socket;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
//            System.out.println("建立連接失敗");
//            e.printStackTrace();
            throw new RuntimeException("建立連接失敗");
        }
        return socket;
    }

    public Object sendRequest(RpcRequest request) {
        Socket socket = null;
        try {
            socket = newSocket();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object result = inputStream.readObject();
            inputStream.close();
            outputStream.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("發送數據異常" + e);
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
