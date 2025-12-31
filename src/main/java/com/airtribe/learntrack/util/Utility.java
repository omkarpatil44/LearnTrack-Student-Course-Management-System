package com.airtribe.learntrack.util;

public class Utility {

        private static int studentIdCounter = 0;

        private  static int courseIdCounter = 0;

        public static int getNextStudentId() {
            return ++studentIdCounter;
        }
        public static int getNextCourseId() {
            return ++courseIdCounter;
        }
}
