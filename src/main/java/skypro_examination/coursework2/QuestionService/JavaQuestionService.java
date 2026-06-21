package skypro_examination.coursework2.QuestionService;

import org.springframework.stereotype.Service;
import skypro_examination.coursework2.Question.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private List<Question> questions = new ArrayList<>();
    private Random random = new Random();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }

    @Override
    public void remove(Question question) {

    }

    @Override
    public Collection<Question> getAll() {
        return List.of();
    }
}
