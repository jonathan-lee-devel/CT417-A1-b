package org.example;

import org.example.model.Student;

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
    }

    public static Student createStudent(String name, int age, String dob, int id) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setDob(dob);
        student.setId(id);

        return student;
    }

}
