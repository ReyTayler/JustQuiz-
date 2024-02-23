package com.example.Quiz.persistance;

import com.example.Quiz.businesslayer.Quiz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {
    Quiz findQuizById(Long id);
}
