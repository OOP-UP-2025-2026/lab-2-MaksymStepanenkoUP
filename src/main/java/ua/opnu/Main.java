package ua.opnu;

public class Main {

    /**
     * Чall the functions to create the Stepanenko object,
     * fill it with courses, and display the information.
     * @param args command-line arguments
     */

    public static void main(final String[] args) {
        Student stepanenko = createStepanenko();
        fillCourses(stepanenko);
        printStudentInfo(stepanenko);
    }

    private static Student createStepanenko() {
        String[] courses = {"", "", "", "", "", "", ""};
        return new Student("Степаненко Максим", 2, courses);
    }

    private static void fillCourses(final Student student) {
        student.addCourse("Основи ринкової економіки");
        student.addCourse("Теорія алгоритмів");
        student.addCourse("Засоби Штучного Інтелекту у веб-технологіях");
        student.addCourse("Об'єктно орієнтоване програмування");
        student.addCourse("Українська мова за професійним спрямуванням");
        student.addCourse("Організація баз даних та знань");
        student.addCourse("Теорія ймовіронстей та мат. статистика");
    }

    private static void printStudentInfo(final Student student) {
        System.out.print(student.getName());
        System.out.print(": кількість вивчаємих дисциплін - ");
        System.out.print(student.getCourseCount() + "\n");

        System.out.print(student.getName());
        System.out.print(": рік навчання - ");
        System.out.print(student.getYear() + "\n");

        System.out.print(student.getName());
        System.out.print(": заплатив за навчання - ");
        System.out.print(student.getTuition() + "\n");
    }
}
