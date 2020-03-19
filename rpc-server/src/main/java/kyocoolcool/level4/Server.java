package kyocoolcool.level4;

import kyocoolcool.Teacher;
import kyocoolcool.TeacherService;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

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
            System.out.println("被呼叫次數:"+(++i)+" 次");
        }
        ss.close();
    }

    private static void process(Socket s) throws Exception {
        final InputStream in = s.getInputStream();
        final OutputStream out = s.getOutputStream();
        final ObjectInputStream ois = new ObjectInputStream(in);
        final DataOutputStream dos = new DataOutputStream(out);
        final String methodName = ois.readUTF();
        final Class[] parameterTypes = (Class[])ois.readObject();
        final Object[] args = (Object[]) ois.readObject();
        final TeacherService service = new TeacherServiceImpl();
        final Method method = service.getClass().getMethod(methodName, parameterTypes);
        Teacher teacher = (Teacher) method.invoke(service, args);
        dos.writeInt(teacher.getId());
        dos.writeUTF(teacher.getName());
        dos.flush();
        ois.close();
        dos.close();
    }
}
