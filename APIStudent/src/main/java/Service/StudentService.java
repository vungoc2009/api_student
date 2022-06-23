package Service;

import Entity.Student;
import Repository.StudentDao;

import java.util.List;

public class StudentService {
    public  static StudentDao studentDao = new StudentDao();
    public List<Student> getAll () {
        return studentDao.getAll();
    }
    public boolean addNewStudent(Student student){
        return studentDao.addnew(student);
    }
    public boolean deleteStudent(int id){
        return studentDao.delete(id);
    }
    public boolean update(Student student){
        return studentDao.update(student);
    }
    public List<Student> getByName(String name){
        return studentDao.getByName(name);
    }
    public List<Student> getbyDay(int start, int end) {
        return studentDao.getbyDay(start, end);
    }
    public List<Student> getAllByGender(String gender) {
        return  studentDao.getAllByGender(gender);
    }
    public List<Student> getByClassName(String name) {
        return studentDao.getByClassName(name);
    }
    public List<Student> getByMajor(String major) {
        return studentDao.getByMajor(major);
    }
    public List<Student> getAllByMark(float markBegin, float markEnd) {
        return studentDao.getAllByMark(markBegin,markEnd);
    }
    public List<Student> getAllByBirthday() {
        return studentDao.getAllByBirthday();
    }
}
