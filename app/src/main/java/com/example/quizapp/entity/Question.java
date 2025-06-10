package com.example.quizapp.entity;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> answers;
    private int correctIndex; // Chỉ số đáp án đúng (0, 1, 2, ...)

    public Question(String questionText, List<String> answers, int correctIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }
}
