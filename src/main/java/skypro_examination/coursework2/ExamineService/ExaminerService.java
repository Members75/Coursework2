package skypro_examination.coursework2.ExamineService;

import org.apache.coyote.BadRequestException;
import skypro_examination.coursework2.Question.Question;
import skypro_examination.coursework2.QuestionService.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
