package Controller;

import Entity.Student;
import Service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class controller {
    public static StudentService studentService = new StudentService();
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent() {
        return studentService.getAll();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNew (Student student){
        return studentService.addNewStudent(student)?"thanh cong":"that bai";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id){
        return studentService.deleteStudent(id)?"thanh cong":"that bai";
    }

    @GET
    @Path("/name")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchName(@QueryParam("name") String name){
        return studentService.getByName(name);
    }

    @GET
    @Path("/date")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByDate(@QueryParam("start") int start,@QueryParam("end") int end){
        return studentService.getbyDay(start,end);
    }

    @GET
    @Path("/gender-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByGender(@QueryParam("gender") String gender){
        return studentService.getAllByGender(gender);
    }

    @GET
    @Path("/class-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByClassName(@QueryParam("class") String className){
        return studentService.getByClassName(className);
    }

    @GET
    @Path("/major-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByMajor(@QueryParam("major") String major){
        return studentService.getByMajor(major);
    }

    @GET
    @Path("/mark-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByMark(@QueryParam("start") int markBegin,@QueryParam("end") int markEnd){
        return studentService.getAllByMark(markBegin,markEnd);
    }

    @GET
    @Path("/birthday")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentSameDateToday(){
        return studentService.getAllByBirthday();
    }
}
