package skypro_examination.coursework2.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;
import skypro_examination.coursework2.ExamineService.ExaminerServiceImpl;
import skypro_examination.coursework2.Question.Question;
import skypro_examination.coursework2.QuestionService.QuestionService;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@org.mockito.junit.jupiter.MockitoSettings(strictness = Strictness.LENIENT)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void testGetQuestions_Success() {
        // Создаем тестовые данные
        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");
        Question q3 = new Question("Q3", "A3");

        // Заставляем mock возвращать эти вопросы при вызове getRandomQuestion
        when(questionService.getRandomQuestion()).thenReturn(q1, q2, q3);
        when(questionService.getAllQuestions()).thenReturn(List.of(q1, q2, q3));

        // Вызываем метод
        Collection<Question> result = examinerService.getQuestions(3);

        // Проверяем результат
        assertEquals(3, result.size());
        assertTrue(result.contains(q1));
        assertTrue(result.contains(q2));
        assertTrue(result.contains(q3));
    }

    @Test
    void testGetQuestions_TooMany() {
        when(questionService.getAllQuestions()).thenReturn(List.of(new Question("Q", "A")));

        // Проверяем, что выбрасывается исключение при запросе больше, чем есть
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(2));
    }

    @Test
    void testGetQuestions_Zero() {
        Collection<Question> result = examinerService.getQuestions(0);
        assertTrue(result.isEmpty());
    }
}
