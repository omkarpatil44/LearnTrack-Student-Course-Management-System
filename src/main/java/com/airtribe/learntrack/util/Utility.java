package com.airtribe.learntrack.util;

public class Utility {

        private static int studentIdCounter = 0;

        private static int courseIdCounter = 0;
        
        private static int enrollmentIdCounter = 0;

        public static int getNextStudentId() {
            return ++studentIdCounter;
        }
        
        public static int getNextCourseId() {
            return ++courseIdCounter;
        }
        
        public static int getNextEnrollmentId() {
            return ++enrollmentIdCounter;
        }
}