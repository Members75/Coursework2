package skypro_examination.coursework2.ExamineService;

import org.apache.coyote.BadRequestException;
import skypro_examination.coursework2.Question.Question;
import skypro_examination.coursework2.QuestionService.QuestionService;

import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImpl {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Set<Question> getQuestions(int amount) throws BadRequestException {
        if (amount <= 0) {
            throw new BadRequestException("Amount must be positive");
        }

        Set<Question> result = new HashSet<>();
        Set<Question> allQuestions = questionService.getAll();

        if (amount > allQuestions.size()) {
            throw new BadRequestException("Not enough questions available");
        }

        while (result.size() < amount) {
            Question random = questionService.getRandomQuestion();
            if (random != null) {
                result.add(random);
            }
        }

        return result;
    }
}
