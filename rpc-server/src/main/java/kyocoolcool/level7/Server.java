package kyocoolcool.level7;

import kyocoolcool.HelloService;
import kyocoolcool.util.PackageScan;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chris Chen
 * @version 1.0
 * @className Server
 * @description
 * @date 2020/3/19 2:16 PM
 **/

public class Server {
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        final ServerSocket ss = new ServerSocket(8888);
        int i = 0;
        while (running) {
            final Socket s = ss.accept();//阻塞等待被調用
            process(s);
            s.close();
            System.out.println("被呼叫次數:" + (++i) + " 次");
        }
        ss.close();
    }

    private static void process(Socket s) throws Exception {
        final InputStream in = s.getInputStream();
        final OutputStream out = s.getOutputStream();
        final ObjectInputStream ois = new ObjectInputStream(in);
        final DataOutputStream dos = new DataOutputStream(out);
        final String clazzName = ois.readUTF();
        final String methodName = ois.readUTF();
        final Class[] parameterTypes = (Class[]) ois.readObject();
        final Object[] args = (Object[]) ois.readObject();
        Class clazz=null;
        //從服務註冊表找到具體的類(封裝改良版本)
//        clazz = HelloServiceImpl.class;
        List<?> list =PackageScan.getScanMenus("kyocoolcool.level7");
        a:for (Object o : list) {
            Class<?>[] interfaces=Class.forName(o.toString().split(" ")[1]).getInterfaces();
            b:for (Class<?> anInterface : interfaces) {
                boolean result=anInterface.getName().equals(clazzName);
                if (result) {
                    clazz= Class.forName(o.toString().split(" ")[1]);
                    break a;
                }
            }
        }
        final Method method = clazz.getMethod(methodName, parameterTypes);
        final Object ob = method.invoke(clazz.newInstance(), args);
        final ObjectOutputStream oos = new ObjectOutputStream(dos);
        oos.writeObject(ob);
        dos.flush();
        ois.close();
        dos.close();
    }
}
