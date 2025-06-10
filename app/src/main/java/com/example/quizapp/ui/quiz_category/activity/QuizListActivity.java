package com.example.quizapp.ui.quiz_category.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.entity.QuizCategory;
import com.example.quizapp.ui.quiz.activity.QuizActivity;
import com.example.quizapp.ui.quiz_category.adapter.QuizCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuizListActivity extends AppCompatActivity {

    private RecyclerView rvQuizList;
    private QuizCategoryAdapter adapter;
    private List<QuizCategory> quizCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        rvQuizList = findViewById(R.id.rvQuizList);

        quizCategoryList = new ArrayList<>();
        quizCategoryList.add(new QuizCategory("Toán học", "10 câu hỏi về kiến thức toán", R.drawable.ic_calculator));
        quizCategoryList.add(new QuizCategory("Khoa học", "8 câu hỏi về khoa học", R.drawable.ic_science));
        quizCategoryList.add(new QuizCategory("Lịch sử", "15 câu hỏi về lịch sử Việt Nam", R.drawable.ic_history));
        // Thêm các chủ đề khác...

        adapter = new QuizCategoryAdapter(quizCategoryList, category -> {
            Intent intent = new Intent(this, QuizActivity.class);
            // Có thể truyền dữ liệu chủ đề qua intent nếu cần
            startActivity(intent);
        });

        rvQuizList.setAdapter(adapter);
    }
}
