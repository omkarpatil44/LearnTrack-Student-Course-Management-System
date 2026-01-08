package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constant.Statuses;
import com.airtribe.learntrack.util.Utility;

import java.time.LocalDate;
import java.util.Date;

public class EnrollmentEntity {
    private long id;
    private long studentId;
    private long courseId;
    private LocalDate enrollmentDate;
    private Statuses status;

    public EnrollmentEntity(long studentId, long courseId, Statuses status, LocalDate enrollmentDate) {
        this.id = Utility.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
        this.enrollmentDate = enrollmentDate;
    }

    public long getId() {
        return id;
    }
    public long getStudentId() {
        return studentId;
    }
    public long getCourseId() {
        return courseId;
    }
    public Statuses getStatus() {
        return status;
    }
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
    public void setStatus(Statuses status) {
        this.status = status;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
