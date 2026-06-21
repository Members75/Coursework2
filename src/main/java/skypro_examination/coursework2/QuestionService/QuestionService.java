package skypro_examination.coursework2.QuestionService;

import skypro_examination.coursework2.Question.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    List<Question> getAllQuestions();
    Question getRandomQuestion();

    void remove(Question question);

    Collection<Question> getAll();
}
