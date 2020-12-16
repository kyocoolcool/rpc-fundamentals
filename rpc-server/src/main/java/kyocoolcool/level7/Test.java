package kyocoolcool.level7;

import kyocoolcool.util.PackageScan;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Arrays.toString(Class.forName("kyocoolcool.level7.HelloServiceImpl").getInterfaces()));
    }
}
