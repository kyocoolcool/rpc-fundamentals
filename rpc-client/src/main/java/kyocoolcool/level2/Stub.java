package kyocoolcool.level2;

import kyocoolcool.Teacher;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author Chris Chen
 * @version 1.0
 * @className Stub
 * @description 代理封裝網路通訊部分
 * @date 2020/3/19 3:17 PM
 **/

public class Stub {
    public Teacher findTeacherById(Integer id) throws Exception {
        final Socket s = new Socket("127.0.0.1", 8888);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(id);

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        id = dis.readInt();
        final String name = dis.readUTF();
        final Teacher teacher = new Teacher(id, name);
        dos.close();
        s.close();
        return teacher;
    }

}
