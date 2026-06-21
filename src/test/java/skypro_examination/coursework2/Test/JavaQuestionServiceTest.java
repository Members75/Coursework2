package skypro_examination.coursework2.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import skypro_examination.coursework2.Question.Question;
import skypro_examination.coursework2.QuestionService.QuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    @InjectMocks
    private QuestionService javaQuestionService;

    @Test
    void testAddAndGetAll() {
        Question q1 = new Question("Что такое Java?", "Язык программирования");
        Question q2 = new Question("Что такое Spring?", "Фреймворк");

        javaQuestionService.add(q1);
        javaQuestionService.add(q2);

        List<Question> all = javaQuestionService.getAllQuestions();
        assertEquals(2, all.size());
        assertTrue(all.contains(q1));
        assertTrue(all.contains(q2));
    }

    @Test
    void testRemove() {
        Question q = new Question("Тест", "Ответ");
        javaQuestionService.addQuestion(q);
        javaQuestionService.removeQuestion(q);
        assertTrue(javaQuestionService.getAllQuestions().isEmpty());
    }

    @Test
    void testGetRandomQuestion() {
        Question q = new Question("Тест", "Ответ");
        javaQuestionService.addQuestion(q);
        assertNotNull(javaQuestionService.getRandomQuestion());
    }
}