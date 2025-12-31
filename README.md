# LearnTrack Student & Course Management System

## Project Description

LearnTrack is a console-based Student and Course Management System built in Java. The system allows users to manage students, courses, and enrollments through an interactive menu-driven interface.

### Features

- **Student Management**: Add, view, search, and deactivate students
- **Course Management**: Add, view, search, and deactivate courses  
- **Enrollment Management**: Enroll students in courses, view enrollments, and mark them as completed/cancelled
- **Custom Exception Handling**: Proper error handling with custom exceptions
- **Clean Architecture**: Separation of concerns with DTOs, Entities, and Services

## Class Diagram

```
┌─────────────────┐
│      Main       │
├─────────────────┤
│ + main()        │
│ + displayMenu() │
│ + switchCase()  │
└─────────┬───────┘
          │
          ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ StudentService  │    │  CourseService  │    │EnrollmentService│
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ + addStudent()  │    │ + addCourse()   │    │ + enrollStudent()│
│ + deactivate()  │    │ + deactivate()  │    │ + getEnrollments│
│ + getStudents() │    │ + getCourses()  │    └─────────────────┘
└─────────┬───────┘    └─────────┬───────┘
          │                      │
          ▼                      ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│  StudentEntity  │    │  CourseEntity   │    │ EnrollmentEntity│
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ - firstName     │    │ - courseName    │    │ - studentId     │
│ - lastName      │    │ - description   │    │ - courseId      │
│ - email         │    │ - duration      │    │ - enrollDate    │
│ - batch         │    └─────────────────┘    │ - status        │
└─────────┬───────┘                           └─────────────────┘
          │
          ▼
┌─────────────────┐
│     Person      │
├─────────────────┤
│ - id            │
│ - active        │
│ + getId()       │
│ + setActive()   │
└─────────────────┘

┌─────────────────┐    ┌─────────────────┐
│   StudentDTO    │    │   CourseDTO     │
├─────────────────┤    ├─────────────────┤
│ + firstName     │    │ + courseName    │
│ + lastName      │    │ + description   │
│ + email         │    │ + duration      │
│ + batch         │    └─────────────────┘
└─────────────────┘
```

### Relationships:
- **Inheritance**: StudentEntity and CourseEntity extend Person class
- **Composition**: Services contain collections of their respective entities
- **Dependency**: Main class depends on all service classes
- **Data Transfer**: DTOs are used to transfer data between layers

## How to Compile and Run

### Prerequisites
- Java 11 or higher
- Command line access

### Compilation
1. Navigate to the project root directory:
   ```bash
   cd "LearnTrackStudentandCourseManagementSystem"
   ```

2. Compile the Java files:
   ```bash
   javac -d out src/main/java/com/airtribe/learntrack/*.java src/main/java/com/airtribe/learntrack/**/*.java
   ```

### Running the Application
```bash
java -cp out com.airtribe.learntrack.Main
```

### Usage
1. Run the application
2. Choose from the main menu options (1-4)
3. Follow the prompts for each management section
4. Use option 4 to exit the application

## Project Structure
```
src/main/java/com/airtribe/learntrack/
├── Main.java                 # Main application entry point
├── DTO/                      # Data Transfer Objects
├── entity/                   # Entity classes
├── service/                  # Business logic services
└── util/                     # Utility classes and exceptions
```