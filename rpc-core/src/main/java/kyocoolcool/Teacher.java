package kyocoolcool;

import java.io.Serializable;

/**
 * @author Chris Chen
 * @version 1.0
 * @className Teacher
 * @description
 * @date 2020/3/19 2:07 PM
 **/

public class Teacher implements Serializable {
    private static final long serialVersionUID = -1474495976192177649L;
    private Integer id;
    private String name;

    public Teacher() {
    }

    public Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
