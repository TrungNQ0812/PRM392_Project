package com.example.quizapp.ui.quiz.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.entity.Question;
import com.example.quizapp.ui.quiz.adapter.AnswerAdapter;

import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuizProgress, tvQuestion;
    private RecyclerView rvAnswers;
    private Button btnNext;

    private List<Question> questions;
    private int currentQuestion = 0;
    private int correctCount = 0;
    private AnswerAdapter answerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuizProgress = findViewById(R.id.tvQuizProgress);
        tvQuestion = findViewById(R.id.tvQuestion);
        rvAnswers = findViewById(R.id.rvAnswers);
        btnNext = findViewById(R.id.btnNext);

        // Giả lập dữ liệu câu hỏi
        questions = Arrays.asList(
                new Question("Thủ đô của Việt Nam là gì?",
                        Arrays.asList("Hà Nội", "Hải Phòng", "Đà Nẵng", "TP. Hồ Chí Minh"), 0),
                new Question("Kết quả của 3 x 5 là?",
                        Arrays.asList("8", "15", "35", "10"), 1),
                new Question("Ai là người phát minh ra bóng đèn?",
                        Arrays.asList("Newton", "Edison", "Einstein", "Tesla"), 1)
                // Thêm câu hỏi khác...
        );

        setupQuestion();

        btnNext.setOnClickListener(v -> {
            if (answerAdapter.getSelectedPosition() == questions.get(currentQuestion).getCorrectIndex()) {
                correctCount++;
            }
            currentQuestion++;
            if (currentQuestion < questions.size()) {
                setupQuestion();
            } else {
                showResult();
            }
        });
    }

    private void setupQuestion() {
        Question q = questions.get(currentQuestion);
        tvQuizProgress.setText("Câu " + (currentQuestion + 1) + "/" + questions.size());
        tvQuestion.setText(q.getQuestionText());
        btnNext.setEnabled(false);

        answerAdapter = new AnswerAdapter(q.getAnswers(), pos -> btnNext.setEnabled(true));

        rvAnswers.setLayoutManager(new LinearLayoutManager(this));
        rvAnswers.setAdapter(answerAdapter);
    }

    private void showResult() {
        // Hiển thị kết quả bằng Toast hoặc chuyển sang màn hình kết quả riêng
        Toast.makeText(this, "Bạn trả lời đúng " + correctCount + "/" + questions.size() + " câu!", Toast.LENGTH_LONG).show();
        // Hoặc finish(); để quay lại màn trước, hoặc mở activity khác để xem chi tiết
        finish();
    }
}
