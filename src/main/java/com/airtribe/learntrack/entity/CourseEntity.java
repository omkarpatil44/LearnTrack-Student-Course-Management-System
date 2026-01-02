package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.Utility;

public class CourseEntity {

    public long id;
    public String courseName;
    public String description;
    public Integer durationInWeeks;
    public boolean active;

    public CourseEntity(String courseName,String description,Integer durationInWeeks,boolean active){
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
        this.setId();
    }

    public long getId(){
        return id;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getDescription() {
        return description;
    }
    public Integer getDurationInWeeks() {
        return durationInWeeks;
    }
    public boolean getActive() {
        return active;
    }

    public void setId() {
        this.id = Utility.getNextCourseId();
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDurationInWeeks(Integer durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

}
