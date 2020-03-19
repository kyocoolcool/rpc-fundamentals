package kyocoolcool.level3;

import kyocoolcool.Teacher;
import kyocoolcool.TeacherService;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author Chris Chen
 * @version 1.0
 * @className Stub
 * @description 代理封裝網路通訊部分
 * @date 2020/3/19 3:17 PM
 **/

public class Stub {
    public static TeacherService getStub() {
        InvocationHandler h=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                final Socket s = new Socket("127.0.0.1", 8888);
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                final DataOutputStream dos = new DataOutputStream(baos);
                dos.writeInt(123);

                s.getOutputStream().write(baos.toByteArray());
                s.getOutputStream().flush();

                DataInputStream dis = new DataInputStream(s.getInputStream());
                Integer id = dis.readInt();
                final String name = dis.readUTF();
                System.out.println("id:" + id);
                System.out.println("name:"+name);
                final Teacher teacher = new Teacher(id, name);
                dos.close();
                s.close();
                return teacher;
            }
        };
        Object o = Proxy.newProxyInstance(TeacherService.class.getClassLoader(), new Class[]{TeacherService.class}, h);
        System.out.println(o.getClass().getName());
        System.out.println(o.getClass().getInterfaces()[0]);
        return (TeacherService)o;
    }
}
