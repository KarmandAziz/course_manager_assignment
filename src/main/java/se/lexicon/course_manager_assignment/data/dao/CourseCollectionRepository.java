package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.model.Course;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;


public class CourseCollectionRepository implements CourseDao {

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        return new Course(CourseSequencer.nextCourseId(), courseName, startDate, weekDuration);

    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        throw new IllegalArgumentException("Id is not found");
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        Collection<Course> found = new HashSet<>();
        for (Course a : courses) {
            if (a.getCourseName().contains(name)) {
                found.add(a);
            }else throw new IllegalArgumentException("Name is not found");
        }
        return found;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        Collection<Course> endDate = new HashSet<>();
        for (Course a : courses) {
            if (a.getStartDate().isBefore(end)) {
                endDate.add(a);
            }
        }
        return endDate;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        Collection<Course> startDate = new HashSet<>();
        for (Course a : courses) {
            if (a.getStartDate().isAfter(start)) {
                startDate.add(a);
            }
        }
        return startDate;
    }

    @Override
    public Collection<Course> findAll() {
        return this.courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        Collection<Course> found = new HashSet<>();
        for (Course a : courses) {
            if (a.getStudents().contains(studentId)) {
                found.add(a);
            } else throw new IllegalArgumentException("Student now found");
        }
        return found;
    }

    @Override
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }
        @Override
        public void clear () {
            this.courses = new HashSet<>();
        }
    }
