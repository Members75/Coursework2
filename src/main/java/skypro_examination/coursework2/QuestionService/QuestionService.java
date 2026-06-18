package skypro_examination.coursework2.QuestionService;

import skypro_examination.coursework2.Question.Question;

import java.util.Set;

public interface QuestionService {
    void add(String question, String answer);
    void add(Question question);
    void remove(Question question);
    Set<Question> getAll();
    Question getRandomQuestion();
}
