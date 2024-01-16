package ru.gb.Students;

import lombok.Data;

@Data
public class Student {
    private static long idConunter = 1L;
    private final long id;
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.id = idConunter++;
        this.name = name;
        this.groupName = groupName;
    }
}
