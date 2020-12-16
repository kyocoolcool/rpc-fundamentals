package kyocoolcool.level7;

import kyocoolcool.Teacher;
import kyocoolcool.TeacherService;

/**
 * @author Chris Chen
 * @version 1.0
 * @className TeacherServiceImpl
 * @description
 * @date 2020/3/19 2:14 PM
 **/
@Service("789")
public class TeacherServiceImpl implements TeacherService {
    @Override
    public Teacher findTeacherById(Integer id) {
        return new Teacher(id,"Mary");
    }
}
