package org.example;

import org.example.model.Course;
import org.example.model.Module;
import org.example.model.Student;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        Student student1 = createStudent("John Doe", 33, "1987-08-08", 42342348);
        Student student2 = createStudent("Jane Doe", 23, "1997-08-08", 93837562);
        Student student3 = createStudent("Ryan Crest", 21, "1999-08-08", 39485729);
        Student student4 = createStudent("Hannah Albert", 22, "1998-08-08", 30293847);
        Student student5 = createStudent("Sarah Ford", 23, "1997-08-08", 12293847);

        Module module1 = createModule("Statistics", "ST334");
        Module module2 = createModule("Calculus", "CA335");
        Module module3 = createModule("Software Engineering", "SE417");
        Module module4 = createModule("Systems", "SY834");
        Module module5 = createModule("Business", "BU101");

        registerStudentForModule(student1, module1);
        registerStudentForModule(student1, module2);
        registerStudentForModule(student1, module3);

        registerStudentForModule(student2, module1);
        registerStudentForModule(student2, module2);
        registerStudentForModule(student2, module3);

        registerStudentForModule(student3, module4);
        registerStudentForModule(student3, module5);

        registerStudentForModule(student4, module4);
        registerStudentForModule(student4, module5);

        registerStudentForModule(student5, module4);
        registerStudentForModule(student5, module5);

        Course course1 = createCourse("BCT", DateTime.now(), DateTime.now());
        registerModuleForCourse(module1, course1);
        registerModuleForCourse(module2, course1);
        registerModuleForCourse(module3, course1);

        Course course2 = createCourse("MAT", DateTime.now(), DateTime.now());
        registerModuleForCourse(module4, course2);
        registerModuleForCourse(module5, course2);

        // Student 1
        printStudent("student1", student1);

        // Student 2
        printStudent("student2", student2);

        // Student 3
        printStudent("student3", student3);

        // Student 4
        printStudent("student4", student4);

        // Student 5
        printStudent("student5", student5);

    }

    private static void printStudent(String prefix, Student student) {
        System.out.printf("[%s]: [%s]\nModules:%s\n--------------------------\n",
                prefix, student.getUsername(), student.getModuleList());
    }

    private static Student createStudent(String name, int age, String dob, int id) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setDob(dob);
        student.setId(id);

        student.setModuleList(new ArrayList<Module>());

        return student;
    }

    private static Module createModule(String name, String id) {
        Module module = new Module();
        module.setName(name);
        module.setId(id);

        module.setStudentList(new ArrayList<Student>());
        module.setCourseList(new ArrayList<Course>());

        return module;
    }

    private static void registerStudentForModule(Student student, Module module) {
        student.getModuleList().add(module);
        module.getStudentList().add(student);
    }

    private static Course createCourse(String name, DateTime startDate, DateTime endDate) {
        Course course = new Course();
        course.setName(name);
        course.setStartDate(startDate);
        course.setEndDate(endDate);

        course.setModuleList(new ArrayList<Module>());
        course.setStudentList(new ArrayList<Student>());

        return course;
    }

    private static void registerModuleForCourse(Module module, Course course) {
        course.getModuleList().add(module);
    }

}
