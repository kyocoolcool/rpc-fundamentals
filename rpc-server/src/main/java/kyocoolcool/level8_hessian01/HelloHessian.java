package kyocoolcool.level8_hessian01;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import kyocoolcool.Dog;
import kyocoolcool.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static kyocoolcool.RpcUtil.deSerialize;
import static kyocoolcool.RpcUtil.serialize;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/12/17 10:45 AM
 **/
public class HelloHessian {
    public static void main(String[] args) throws IOException {
        final Dog dog = new Dog("Ann",28);
        final byte[] bytes = serialize(dog);
        System.out.println(bytes.length);
        Dog dogDeserialize = (Dog) deSerialize(bytes);
        System.out.println(dogDeserialize);

    }
}
