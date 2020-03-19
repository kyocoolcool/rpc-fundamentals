package kyocoolcool.level4;


import kyocoolcool.TeacherService;

/**
 * @author Chris Chen
 * @version 1.0
 * @className Client
 * @description
 * @date 2020/3/19 2:24 PM
 **/

public class Client {
    public static void main(String[] args) throws Exception {
        final TeacherService service = Stub.getStub();
        System.out.println(service.findTeacherById(666));
    }
}
