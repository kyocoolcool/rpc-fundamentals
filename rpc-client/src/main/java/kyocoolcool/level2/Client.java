package kyocoolcool.level2;


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
        final Stub stub = new Stub();
        System.out.println(stub.findTeacherById(666));
    }
}
