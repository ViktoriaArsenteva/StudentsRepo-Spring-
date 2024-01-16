package ru.gb.Students;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Collectors;


@Component
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Viktoria","group1"));
        students.add(new Student("Oleg","group2"));
        students.add(new Student("Stepan","group3"));
        students.add(new Student("Nastya","group4"));
        students.add(new Student("Anna","group5"));
        students.add(new Student("Viktoria","group1"));
        students.add(new Student("Polina","group2"));
        students.add(new Student("Kate","group3"));
        students.add(new Student("Viktor","group4"));
        students.add(new Student("Maria","group5"));
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getById(long id){
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getListByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .collect(Collectors.toList());
    }

    public List<Student> getListByGroupName(String groupName) {
        return students.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName))
                .collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }
}
