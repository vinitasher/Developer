/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codazen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vasher
 */
public class Course {
    
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course(List<Student> students) {
        this.students = students;
    }
    
    public Course() {
        this.students = new ArrayList<>();
    }
    
    public void addStudent(Student student){
        this.students.add(student);
    }
    
}
