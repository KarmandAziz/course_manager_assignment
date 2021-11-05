package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student = new Student(StudentSequencer.nextStudentId(), name, email,address);
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for(Student student : students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }
        throw new IllegalArgumentException("Email is not found");

    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> student = new HashSet<>();
        for(Student a : students){
            if(a.getName().contains(name)){
                student.add(a);
            }
        }
        return student;
    }

    @Override
    public Student findById(int id) {
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        throw new IllegalArgumentException("Id is not found");
    }

    @Override
    public Collection<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean removeStudent(Student student) {
      return students.remove(student);

        }

        @Override
        public void clear () {
            this.students = new HashSet<>();
        }

    }

