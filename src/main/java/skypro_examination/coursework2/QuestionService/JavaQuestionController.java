package skypro_examination.coursework2.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skypro_examination.coursework2.Question.Question;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService javaQuestionService;

    @Autowired
    public JavaQuestionController(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PostMapping("/add")
    public void addQuestion(
            @RequestParam String question,
            @RequestParam String answer) {
        javaQuestionService.addQuestion(new Question(question, answer));
    }

    @DeleteMapping("/remove")
    public void removeQuestion(
            @RequestParam String question,
            @RequestParam String answer) {
        javaQuestionService.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return javaQuestionService.getAll();
    }
}
