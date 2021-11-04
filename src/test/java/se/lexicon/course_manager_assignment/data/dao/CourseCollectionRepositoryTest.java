package se.lexicon.course_manager_assignment.data.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.data.dao.CourseCollectionRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {CourseCollectionRepository.class})
public class CourseCollectionRepositoryTest {

    public static final int ID = 1;
    public static final String COURSE_NAME = "Programming";
    public static final LocalDate START_DATE = LocalDate.parse("2021-11-11");
    public static final int WEEK_DURATION = 4;
    @Autowired
    private CourseDao testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    @BeforeEach
    public void setup(){
        testObject.createCourse(
                "Programming",
                LocalDate.parse("2021-11-11"),
                4);
    }

    @Test
    public void testObject_successfully_created(){
        Assertions.assertNotNull(testObject);



    }






    @AfterEach
    void tearDown() {
        testObject.clear();
        CourseSequencer.setCourseSequencer(0);
    }
}
