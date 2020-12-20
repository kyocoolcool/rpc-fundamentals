package kyocoolcool.level9_hessian02;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import kyocoolcool.Dog;

import java.io.*;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/12/17 10:45 AM
 **/
public class HessianVSJDK {
    public static void main(String[] args) throws IOException {
        final Dog dog = new Dog("Ann",28);
        final byte[] bytes = hessianSerialize(dog);
        final byte[] bytes2 = jdkSerialize(dog);
        System.out.println("hessian:"+bytes.length);
        System.out.println("jdk:"+bytes2.length);
    }

    private static Object hessianDeSerialize(byte[] bytes) throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        final Hessian2Input hessian2Input = new Hessian2Input(byteArrayInputStream);
        final Object o = hessian2Input.readObject();
        hessian2Input.close();
        byteArrayInputStream.close();
        return o;
    }

    public static byte[] hessianSerialize(Object o) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final Hessian2Output hessian2Output = new Hessian2Output(byteArrayOutputStream);
        hessian2Output.writeObject(o);
        hessian2Output.flush();
        final byte[] bytes = byteArrayOutputStream.toByteArray();
        hessian2Output.close();
        byteArrayOutputStream.close();
        return bytes;
    }

    private static Object jdkDeSerialize(byte[] bytes) throws IOException, ClassNotFoundException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        final ObjectInputStream oos = new ObjectInputStream(byteArrayInputStream);
        final Object o = oos.readObject();
        oos.close();
        byteArrayInputStream.close();
        return o;
    }

    public static byte[] jdkSerialize(Object o) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(o);
        oos.flush();
        final byte[] bytes = byteArrayOutputStream.toByteArray();
        oos.close();
        byteArrayOutputStream.close();
        return bytes;
    }
}
