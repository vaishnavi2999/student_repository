package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student=new Student(
                1,
                "john",
                "doe"

        );
        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header","john")
                .body(student);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents()
    {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"John","Deo"));
        students.add(new Student(2,"Mary","Deo"));
        students.add(new Student(3,"Jae","Deo"));
        students.add(new Student(4,"Andie","Deo"));
        return ResponseEntity.ok(students);
    }

    //Spring BOOT REST API with path variable
    //{id}-URI Template Variable
    //http:localhost:8080/students/1/john/deo
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> student(@PathVariable("id") int studentId,
                           @PathVariable("first-name") String firstName,
                           @PathVariable("last-name") String lastName)
    {
        Student student = new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
      }

      //Spring Boot REST API with request Param
     //http:localhost:8080/students/query?id=1&firstName=John&lastName=Deo
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName)
    {
        Student student = new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //Spring boot Rest Api that handles HTTP Post Request - creating new resource
    //@PostMapping and @RequestBody
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    //Spring Boot API that handles HTTP Put Request - for updating the resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring Boot API that handles HTTP Delete Request
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }




}
