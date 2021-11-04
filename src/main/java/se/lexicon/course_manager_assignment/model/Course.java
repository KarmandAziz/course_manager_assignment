package se.lexicon.course_manager_assignment.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }


    public int getId() {
        return id;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        if(students == null){
            students = new ArrayList<>();
        }
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean addStudent(Student student){
        if(student == null) throw new IllegalArgumentException("Student was null");{
            if(students == null){
                students = new ArrayList<>();
            }
            if(!students.contains(student)){
                return students.add(student);
            }
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("Student was null");
        {
            if (students == null) {
                students = new ArrayList<>();
            }
        }
        return students.remove(student);
    }

}
