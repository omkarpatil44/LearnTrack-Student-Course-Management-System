package com.airtribe.learntrack;

import com.airtribe.learntrack.DTO.CourseDTO;
import com.airtribe.learntrack.DTO.StudentDTO;
import com.airtribe.learntrack.entity.CourseEntity;
import com.airtribe.learntrack.entity.EnrollmentEntity;
import com.airtribe.learntrack.entity.StudentEntity;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws IOException {

        System.out.println("Hello and welcome to the LearnTrack Student & Course Management System (Core Java) Application");

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();
        Main mainClass = new Main();
        mainClass.displayMenu(studentService, courseService,enrollmentService);

    }

    public void switchCase(String management, StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {

        try {
            BufferedReader managementReader = new BufferedReader(new InputStreamReader(System.in));
            switch (management) {
                case "1":
                    System.out.println("Welcome to the Student Management,Please select");
                    System.out.println("1 to Add new Student.");
                    System.out.println("2 to View all Student.");
                    System.out.println("3 to Search student by ID.");
                    System.out.println("4 to Deactivate a student.");
                    System.out.println("5 to exit.");
                    String studentManagement = managementReader.readLine();
                    this.studentManagement(studentManagement, studentService,courseService,enrollmentService);
                    break;
                case "2":
                    System.out.println("Welcome to the Course Management,,Please select");
                    System.out.println("1 to Add new Course.");
                    System.out.println("2 to View all Course.");
                    System.out.println("3 to Search Course by ID.");
                    System.out.println("4 to Deactivate a Course.");
                    System.out.println("5 to exit.");
                    String courseManagement = managementReader.readLine();
                    this.courseManagement(courseManagement, studentService,courseService,enrollmentService);
                    break;
                case "3":
                    System.out.println("Welcome to the Enrollment Management,Please select");
                    System.out.println("1 to Enroll a student in a course.");
                    System.out.println("2 to View all enrollments.");
                    System.out.println("3 to View enrollments for a student.");
                    System.out.println("4 to Mark enrollment as completed/cancelled");
                    System.out.println("5 to exit.");
                    String enrollmentManagement = managementReader.readLine();
                    this.enrollmentManagement(enrollmentManagement, studentService, courseService, enrollmentService);
                    break;
                case "4":
                    System.out.println("Exit");
                    break;
                default :
                    System.out.println("Invalid choice");
                    this.switchCase("1", studentService, courseService, enrollmentService);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void displayMenu(StudentService studentService, CourseService courseService,EnrollmentService enrollmentService) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your choice");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("4. Exit");

        String management = reader.readLine();
        Main mainClass = new Main();
        mainClass.switchCase(management, studentService, courseService,enrollmentService);
    }

    public void studentManagement(String studentManagement, StudentService studentService, CourseService courseService,EnrollmentService enrollmentService){

        try {
            BufferedReader stReader = new BufferedReader(new InputStreamReader(System.in));
            switch (studentManagement) {
                case "1" -> {
                    StudentDTO studentdto = new StudentDTO();
                    System.out.println("Please enter student first name ");
                    studentdto.firstName = stReader.readLine();
                    System.out.println("Please enter student last name ");
                    studentdto.lastName = stReader.readLine();
                    System.out.println("Please enter student Email Id");
                    studentdto.email = stReader.readLine();
                    System.out.println("Please enter student Batch name ");
                    studentdto.batch = stReader.readLine();
                    boolean res = studentService.addStudent(studentdto);
                    if (res) {
                        System.out.println("Student Added");
                        this.switchCase("1", studentService, courseService,enrollmentService);
                    }
                }
                case "2" -> {
                    List<StudentEntity> studentEntities = studentService.getStudentEntities();
                    for (StudentEntity student : studentEntities) {
                        displayStudentDetails(student);
                    }
                    this.switchCase("1", studentService, courseService,enrollmentService);
                }
                case "3" -> {
                    List<StudentEntity> studentEntities = studentService.getStudentEntities();
                    System.out.println("Please enter StudentId to search");
                    long id = Long.parseLong(stReader.readLine());

                    try {
                        var searchedStudent = studentEntities.stream().filter(m -> m.getId() == id).findAny();
                        if (searchedStudent.isEmpty()) {
                            throw new CustomException("Student not found for student id 4 Please choose another student id");
                        }
                        this.displayStudentDetails(searchedStudent.get());
                    } catch (CustomException ex) {
                        System.out.println(ex.getMessage());
                    }

                    this.switchCase("1", studentService, courseService,enrollmentService);
                }
                case "4" -> {

                    System.out.println("Please enter StudentId to Deactivate");
                    long id = Long.parseLong(stReader.readLine());
                    var searchedStudent = studentService.deactivateStudent(id);
                    if (searchedStudent.getId() > 0) {
                        this.displayStudentDetails(searchedStudent);
                    } else {
                        System.out.println("Student not found");
                    }
                    this.switchCase("1", studentService, courseService,enrollmentService);
                }
                case "5" -> {
                    displayMenu(studentService, courseService,enrollmentService);
                }
                default -> {
                    System.out.println("Invalid choice");
                    this.switchCase("1", studentService, courseService, enrollmentService);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void courseManagement(String courseManagement,StudentService studentService, CourseService courseService,EnrollmentService enrollmentService) {
        try {
            BufferedReader cReader = new BufferedReader(new InputStreamReader(System.in));
            switch (courseManagement) {
                case "1" -> {
                    CourseDTO courseDto = new CourseDTO();
                    System.out.println("Please enter course name ");
                    courseDto.courseName = cReader.readLine();
                    System.out.println("Please enter course description ");
                    courseDto.description = cReader.readLine();
                    System.out.println("Please enter duration In Weeks ");
                    courseDto.durationInWeeks = Integer.valueOf(cReader.readLine());
                    boolean res = courseService.addCourse(courseDto);
                    if (res) {
                        System.out.println("Course Added");
                        this.switchCase("2", studentService, courseService,enrollmentService);
                    }
                }
                case "2" -> {
                    List<CourseEntity> courseEntities = courseService.getCourseEntities();
                    for (CourseEntity course : courseEntities) {
                        displayCourseDetails(course);
                    }
                    this.switchCase("2", studentService, courseService,enrollmentService);
                }
                case "3" -> {
                    List<CourseEntity> courseEntities = courseService.getCourseEntities();
                    System.out.println("Please enter CourseId to search");
                    long id = Long.parseLong(cReader.readLine());
                    var searchedCourse = courseEntities.stream().filter(c -> c.getId() == id).findAny();
                    if (searchedCourse.isPresent()) {
                        this.displayCourseDetails(searchedCourse.get());
                    } else {
                        System.out.println("Course not found");
                    }
                    this.switchCase("2", studentService, courseService,enrollmentService);
                }
                case "4" -> {
                    System.out.println("Please enter CourseId to Deactivate");
                    long id = Long.parseLong(cReader.readLine());
                    var searchedCourse = courseService.deactivateCourse(id);
                    if (searchedCourse.getId() > 0) {
                        this.displayCourseDetails(searchedCourse);
                    } else {
                        System.out.println("Course not found");
                    }
                    this.switchCase("2", studentService, courseService,enrollmentService);
                }
                case "5" ->{
                    displayMenu(studentService, courseService,enrollmentService);
                }
                default -> {
                    System.out.println("Invalid choice");
                    this.switchCase("2", studentService, courseService, enrollmentService);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enrollmentManagement(String enrollmentManagement, StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        try {
            BufferedReader eReader = new BufferedReader(new InputStreamReader(System.in));
            switch (enrollmentManagement) {
                case "1" -> {
                    System.out.println("Please enter StudentId to enroll");
                    long studentId = Long.parseLong(eReader.readLine());
                    System.out.println("Please enter CourseId to enroll");
                    long courseId = Long.parseLong(eReader.readLine());
                    String res = enrollmentService.enrollStudent(studentId, courseId);
                    System.out.println(res);
                    this.switchCase("3", studentService, courseService,enrollmentService);

                }
                case "2" -> {
                    List<EnrollmentEntity> enrollmentEntities = enrollmentService.getEnrollmentEntityList();
                    for (EnrollmentEntity enrollmentEntity : enrollmentEntities) {
                        displayEnrollmentDetails(enrollmentEntity, studentService, courseService);
                    }
                    this.switchCase("3", studentService, courseService,enrollmentService);
                }
                case "3" -> {
                    System.out.println("Please enter StudentId to view enrollments");
                    long studentId = Long.parseLong(eReader.readLine());
                    List<EnrollmentEntity> enrollmentEntities = enrollmentService.getEnrollmentEntityListByStudentId(studentId);
                    for (EnrollmentEntity enrollmentEntity : enrollmentEntities) {
                        displayEnrollmentDetails(enrollmentEntity, studentService, courseService);
                    }
                    this.switchCase("3", studentService, courseService,enrollmentService);
                }
                case "4" -> {
                    System.out.println("Please enter EnrollmentId to mark as completed/cancelled, Enter 1 to Complete or 2 to Cancel");
                    long enrollmentId = Long.parseLong(eReader.readLine());
                    System.out.println("Please enter 1 to Complete or 2 to Cancel");
                    long status = Long.parseLong(eReader.readLine());
                    EnrollmentEntity res = enrollmentService.getEnrollmentEntityByStudentIdAndCourseId(enrollmentId,status);
                    if (res != null) {
                        System.out.println("Enrollment marked as completed");
                        this.switchCase("3", studentService, courseService,enrollmentService);
                    }
                }
                case "5" -> {
                    displayMenu(studentService, courseService,enrollmentService);
                }
                default -> {
                    System.out.println("Invalid choice");
                    this.switchCase("3", studentService, courseService, enrollmentService);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void displayStudentDetails(StudentEntity student) {
        System.out.println(student.getId() + " , " + student.getFirstName() + " , " + student.getLastName() + " , " + student.getEmail() + " , " + student.getBatch() + " , " + student.getActive());
    }

    public void displayCourseDetails(CourseEntity course) {
        System.out.println(course.getId() + " , " + course.getCourseName() + " , " + course.getDescription() + " , " + course.getDurationInWeeks() + " , " + course.getActive());
    }

    public void displayEnrollmentDetails(EnrollmentEntity enrollment, StudentService studentService, CourseService courseService) {
        StudentEntity student = studentService.getStudentEntities().stream()
                .filter(s -> s.getId() == enrollment.getStudentId())
                .findFirst()
                .orElse(null);
        
        CourseEntity course = courseService.getCourseEntities().stream()
                .filter(c -> c.getId() == enrollment.getCourseId())
                .findFirst()
                .orElse(null);
        
        String studentName = student != null ? student.getFirstName() + " " + student.getLastName() : "Unknown";
        String courseName = course != null ? course.getCourseName() : "Unknown";
        
        System.out.println(enrollment.getId() + ", " + enrollment.getStudentId() + " (" + studentName + "), " + enrollment.getCourseId() + " (" + courseName + "), " + enrollment.getEnrollmentDate() + ", " + enrollment.getStatus());
    }

}
