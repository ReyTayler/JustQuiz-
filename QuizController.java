package com.example.Quiz.presentation;

import com.example.Quiz.businesslayer.Quiz;
import com.example.Quiz.businesslayer.QuizService;

import com.example.Quiz.businesslayer.ServerAnswers;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class QuizController {
    @Autowired
    QuizService service;

    //Запрос на добавление нового вопроса в базу данных
    @PostMapping("/api/quizzes/addQuestion")
    public Quiz addQuestion(@Valid @RequestBody Quiz quiz) {
       return service.saveQuestion(new Quiz(quiz.getTitle(), quiz.getText(), quiz.getOptions(), quiz.getAnswer()));
    }

    //Запрос на получение вопроса из базы данных по его ID
    @GetMapping("/api/quizzes/getQuestion/{id}")
    public Quiz getQuestionById(@PathVariable Long id) {
       return service.getQuestion(id);
    }

    //Получение полного списка вопросов из викторины
    @GetMapping("/api/quizzes/getAllQuestions")
    public Iterable<Quiz> getAllQuestions() {
        return service.getAllQuestions();
    }

    //Удаление вопроса из базы данных по его ID
    @DeleteMapping("/api/quizzes/deleteQuestion/{id}")
    public String deleteQuestionById(@PathVariable Long id) {
        return service.deleteQuestion(id);
    }

    //Получение ответа от сервера при попытке решить викторину
    @PostMapping("/api/quizzes/solve/{id}")
    public ServerAnswers getAnswerFromServer(@RequestBody Quiz quiz, @PathVariable Long id) {
        Arrays.sort(quiz.getAnswer());
        return service.solveQuiz(id, quiz.getAnswer());
    }
}
