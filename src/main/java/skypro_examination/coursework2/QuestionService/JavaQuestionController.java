package skypro_examination.coursework2.QuestionService;

import org.springframework.web.bind.annotation.*;
import skypro_examination.coursework2.Question.Question;

import java.util.Set;

@RestController
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/exam/java/add")
    public void addQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.add(question, answer);
    }

    @DeleteMapping("/exam/java/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.remove(new Question(question, answer));
    }

    @GetMapping("/exam/java")
    public Set<Question> getAllQuestions() {
        return questionService.getAll();
    }
}
