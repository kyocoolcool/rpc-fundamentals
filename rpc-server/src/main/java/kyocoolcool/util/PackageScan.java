package kyocoolcool.util;

import kyocoolcool.level7.Service;
import org.reflections.Reflections;
import java.util.*;

public class PackageScan {
    public static List<?> getScanMenus(String packageName) {
        Reflections f = new Reflections(packageName);
        Set<Class<?>> set = f.getTypesAnnotatedWith(Service.class);
     List<Object> list=new ArrayList<Object>();
        for (Class<?> c : set) {
            list.add(c);
            Service annotation = c.getAnnotation(Service.class);
            Arrays.asList(annotation.value()).forEach(System.out::println);
        }
        return list;
    }
}
