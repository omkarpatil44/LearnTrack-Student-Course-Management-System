package com.airtribe.learntrack.service;

import com.airtribe.learntrack.DTO.StudentDTO;
import com.airtribe.learntrack.entity.Person;
import com.airtribe.learntrack.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    List<StudentEntity> studentEntities = new ArrayList<>();

    public StudentService(){
        studentEntities.add(new StudentEntity("Sachin", "Tendulkar", "sachine.tendulkar@gmail.com", "C15",Boolean.TRUE));
        studentEntities.add(new StudentEntity("Virat", "Kohli", "virat.kohli@gmail.com", "C16",Boolean.TRUE));
    }

    public Boolean addStudent(StudentDTO studentdto) {
        StudentEntity student = new StudentEntity(studentdto.firstName,studentdto.lastName,studentdto.email,studentdto.batch,Boolean.TRUE);
        studentEntities.add(student);
        return true;
    }

    public void addStudentWithoutMailId(StudentDTO studentdto) {
        StudentEntity student = new StudentEntity(studentdto.firstName,studentdto.lastName,studentdto.batch,Boolean.TRUE);
        studentEntities.add(student);
    }

    public StudentEntity deactivateStudent(long id) {
        StudentEntity student = studentEntities.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if(student != null) {
            student.setActive(Boolean.FALSE);
        }
        return student;
    }


    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }
}
