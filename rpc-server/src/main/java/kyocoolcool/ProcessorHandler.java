package kyocoolcool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @ClassName ProcessorHandler
 * @Description 處理程序
 * @Author chris
 * @Date 2019/12/2 2:27 PM
 * @Version 1.0
 **/

public class ProcessorHandler implements Runnable {
    Socket socket;
    Object service;

    public ProcessorHandler() {
    }

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }


    @Override
    public void run() {
        System.out.println("開始處理客戶端請求");

        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            try {
                RpcRequest rpcRequest = (RpcRequest) inputStream.readObject();//jaca反序列化
                Object result = invoke(rpcRequest);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(result);
                outputStream.flush();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //通過反射調用
    private Object invoke(RpcRequest request) {
        Object[] args = request.getParameters();
        Class<?>[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }
        try {
            Method method = service.getClass().getMethod(request.getMethodName(), types);
            Object result = null;
            try {
                result = method.invoke(service, args);
                return result;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}