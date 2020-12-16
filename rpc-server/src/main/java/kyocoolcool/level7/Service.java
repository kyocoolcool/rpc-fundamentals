package kyocoolcool.level7;

import java.lang.annotation.*;
@Target({ElementType.FIELD,ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String[] value();
}
