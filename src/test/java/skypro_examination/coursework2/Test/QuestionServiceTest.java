package skypro_examination.coursework2.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro_examination.coursework2.Question.Question;
import skypro_examination.coursework2.QuestionService.JavaQuestionServiceImpl;
import skypro_examination.coursework2.QuestionService.QuestionService;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceTest {

    private QuestionService service;

    @BeforeEach
    public void setUp() {
        service = new JavaQuestionServiceImpl();
    }

    @Test
    public void testAddAndRemoveWithEmptyCollection() {
        service.add("Q1", "A1");
        assertEquals(1, service.getAll().size());

        service.remove(new Question("Q1", "A1"));
        assertTrue(service.getAll().isEmpty());
    }

    @Test
    public void testDuplicateAdd() {
        service.add("Q1", "A1");
        service.add("Q1", "A1"); // Дубликат
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void testRandomQuestionEmpty() {
        assertNull(service.getRandomQuestion());
    }
}