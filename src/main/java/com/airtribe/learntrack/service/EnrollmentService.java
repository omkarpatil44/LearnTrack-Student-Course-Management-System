package com.airtribe.learntrack.service;

import com.airtribe.learntrack.constant.Statuses;
import com.airtribe.learntrack.entity.EnrollmentEntity;
import com.airtribe.learntrack.util.Utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnrollmentService {

    List<EnrollmentEntity> enrollmentEntityList = new ArrayList<>();

    public EnrollmentService(){
        enrollmentEntityList.add(new EnrollmentEntity(1, 1, Statuses.ACTIVE, LocalDate.now()));
        enrollmentEntityList.add(new EnrollmentEntity( 2, 2, Statuses.ACTIVE, LocalDate.now()));
    }

    public String enrollStudent(long studentId, long courseId) {
        // Check if student is already enrolled in the course
        boolean alreadyEnrolled = enrollmentEntityList.stream()
                .anyMatch(enrollment -> enrollment.getStudentId() == studentId && enrollment.getCourseId() == courseId);
        
        if (alreadyEnrolled) {
            return "Student already enrolled in this course";
        }
        
        EnrollmentEntity enrollment = new EnrollmentEntity(studentId, courseId, Statuses.ACTIVE, LocalDate.now());
        enrollmentEntityList.add(enrollment);
        return "Student enrolled successfully";
    }

    public List<EnrollmentEntity> getEnrollmentEntityList() {
        return enrollmentEntityList;
    }

    public List<EnrollmentEntity> getEnrollmentEntityListByStudentId(long studentId) {
        List<EnrollmentEntity> enrollmentEntities = new ArrayList<>();
        for(EnrollmentEntity enrollmentEntity : enrollmentEntityList) {
            if(enrollmentEntity.getStudentId() == studentId) {
                enrollmentEntities.add(enrollmentEntity);
            }
        }
        return enrollmentEntities;
    }

    public EnrollmentEntity getEnrollmentEntityByStudentIdAndCourseId(long studentId, long courseId) {
        return enrollmentEntityList.stream()
                .filter(enrollment -> enrollment.getStudentId() == studentId && enrollment.getCourseId() == courseId)
                .findFirst()
                .orElse(null);
    }

}
