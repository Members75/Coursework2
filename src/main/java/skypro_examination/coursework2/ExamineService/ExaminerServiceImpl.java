package skypro_examination.coursework2.ExamineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skypro_examination.coursework2.Question.Question;
import skypro_examination.coursework2.QuestionService.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> result = new ArrayList<>();
        Set<Integer> usedIndices = new HashSet<>();

        int totalQuestions = questionService.getAllQuestions().size();

        if (amount > totalQuestions) {
            throw new IllegalArgumentException("Запрошено больше вопросов, чем доступно в базе");
        }

        while (result.size() < amount) {
            int randomIndex = new Random().nextInt(totalQuestions);

            if (!usedIndices.contains(randomIndex)) {
                Question randomQuestion = questionService.getRandomQuestion();
                result.add(randomQuestion);
                usedIndices.add(randomIndex);
            }
        }

        return result;
    }
}
