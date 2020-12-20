package kyocoolcool;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/12/17 11:18 AM
 **/
public class RpcUtil {
    public static byte[] serialize(Object o) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final Hessian2Output hessian2Output = new Hessian2Output(byteArrayOutputStream);
        hessian2Output.writeObject(o);
        hessian2Output.flush();
        final byte[] bytes = byteArrayOutputStream.toByteArray();
        hessian2Output.close();
        byteArrayOutputStream.close();
        return bytes;
    }

    public static Object deSerialize(byte[] bytes) throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        final Hessian2Input hessian2Input = new Hessian2Input(byteArrayInputStream);
        final Object o = hessian2Input.readObject();
        hessian2Input.close();
        byteArrayInputStream.close();
        return o;
    }


}
