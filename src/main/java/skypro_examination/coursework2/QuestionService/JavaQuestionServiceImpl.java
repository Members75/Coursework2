package skypro_examination.coursework2.QuestionService;

import skypro_examination.coursework2.Question.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public void add(String question, String answer) {
        this.add(new Question(question, answer));
    }

    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public void remove(Question question) {
        questions.remove(question);
    }

    @Override
    public Set<Question> getAll() {
        return new HashSet<>(questions); // Возвращаем копию
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) return null;
        int randomIndex = new Random().nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIndex);
    }
}
