package com.example.Quiz.businesslayer;

import com.example.Quiz.persistance.QuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QuizService {
    private final QuizRepository repository;

    @Autowired
    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public Quiz saveQuestion(Quiz quiz) {
        return repository.save(quiz);
    }

    public Iterable<Quiz> getAllQuestions() {
        return repository.findAll();
    }

    public Quiz getQuestion(Long id) {
        return repository.findQuizById(id);
    }

    public String deleteQuestion(Long id) {
        repository.deleteById(id);
        return "This question is deleted";
    }

    public ServerAnswers solveQuiz(Long id, int[] answers) {
        if(Arrays.equals(repository.findQuizById(id).getAnswer(), answers)) {
            return new ServerAnswers(true, "You are right!!!");
        }
        else {
            return new ServerAnswers(false, "You are lose!!!");
        }
    }

}
