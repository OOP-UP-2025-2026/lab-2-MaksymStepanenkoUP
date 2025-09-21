package ua.opnu;

import java.util.Objects;

public class Student {

    private String name;
    private int year;
    private String[] courses;

    public Student(String name, int year, String[] courses) {
        this.name = name;
        this.year = year;
    }
    void addCourse(String courseName) {
        for (int i = 0; i < this.courses.length; i++) {
            if (Objects.equals(this.courses[i], "")) {
                this.courses[i] = courseName;
                break;
            }
        }
    }

    void dropAll() {
        for (int i = 0; i < this.courses.length && !Objects.equals(this.courses[i], ""); i++) {
            this.courses[i] = "";
        }
    }

    int getCourseCount() {
        for (int i = 0; i < this.courses.length; i++) {
            if (Objects.equals(this.courses[i], "")) {
                return i;
            }
        }
        return this.courses.length;
    }

    String getName() {
        return this.name;
    }

    int getTuition() {
        int tuitionFee = 20000;
        return getYear() * tuitionFee;
    }

    int getYear() {
        return this.year;
    }
}
