package kyocoolcool;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description
 * @Author chris
 * @Date 2019/12/2 2:10 PM
 * @Version 1.0
 **/

public class User implements Serializable {
    private static final long serialVersionUID = -6619509674759062437L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
