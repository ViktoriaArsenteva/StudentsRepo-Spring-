package ru.gb.Students;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Student> getStudents() {
        return repo.getAll();
    }

    @GetMapping(value = "/id/{id}")
    public Student getStudentById(@PathVariable long id) {
        return repo.getById(id);
    }
    @GetMapping(value = "/name/{name}")
    public List<Student> getStudentListByName(@PathVariable String name) {
        return repo.getListByName(name);
    }
    @GetMapping(value = "/groupName/{groupName}")
    public List<Student> getStudentListByGroupName(@PathVariable String groupName) {
        return repo.getListByGroupName(groupName);
    }
    @PostMapping ("/")
    public Student addNewStudent(@RequestBody Student student) {
        repo.addStudent(student);
        return student;
    }
    @DeleteMapping("/delete/{id}")
    public Student deleteStudent(@PathVariable long id){
        Student student = repo.getById(id);
        repo.deleteStudent(student);
        return student;
    }
}
