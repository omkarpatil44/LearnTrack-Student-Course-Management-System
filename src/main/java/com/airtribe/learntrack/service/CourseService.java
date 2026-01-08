package com.airtribe.learntrack.service;

import com.airtribe.learntrack.DTO.CourseDTO;
import com.airtribe.learntrack.entity.CourseEntity;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    
    List<CourseEntity> courseEntities = new ArrayList<>();
    
    public CourseService() {
        courseEntities.add(new CourseEntity( "Java Programming", "Learn Java basics", 12, Boolean.TRUE));
        courseEntities.add(new CourseEntity("JS Programming", "Node js framework", 16, Boolean.TRUE));
    }
    
    public Boolean addCourse(CourseDTO courseDto) {
        CourseEntity course = new CourseEntity(courseDto.courseName, courseDto.description, courseDto.durationInWeeks, Boolean.TRUE);
        courseEntities.add(course);
        return true;
    }
    
    public CourseEntity deactivateCourse(long id) {
        CourseEntity course = courseEntities.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        
        if(course != null) {
            course.setActive(Boolean.FALSE);
        }
        return course;
    }
    
    public List<CourseEntity> getCourseEntities() {
        return courseEntities;
    }
}