package kyocoolcool.level1;


import kyocoolcool.Teacher;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author Chris Chen
 * @version 1.0
 * @className Client
 * @description
 * @date 2020/3/19 2:24 PM
 **/

public class Client {
    public static void main(String[] args) throws Exception {
        final Socket s = new Socket("127.0.0.1", 8888);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        final int id = dis.readInt();
        final String name = dis.readUTF();
        final Teacher teacher = new Teacher(id, name);

        System.out.println(teacher);
        dos.close();
        s.close();

    }
}
