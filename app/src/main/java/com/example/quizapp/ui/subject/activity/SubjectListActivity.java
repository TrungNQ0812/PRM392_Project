package com.example.quizapp.ui.subject.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.entity.Subject;
import com.example.quizapp.ui.quiz.activity.QuizActivity;
import com.example.quizapp.ui.subject.adapter.SubjectAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;

public class SubjectListActivity extends AppCompatActivity {

    private RecyclerView rvSubjects;
    private SubjectAdapter subjectAdapter;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        rvSubjects = findViewById(R.id.rvSubjects);

        // Mock data - danh sách môn học
        List<Subject> subjectList = Arrays.asList(
                new Subject("toan", "Toán", R.drawable.ic_category),
                new Subject("ly", "Lý", R.drawable.ic_category),
                new Subject("hoa", "Hóa", R.drawable.ic_category),
                new Subject("su", "Sử", R.drawable.ic_category),
                new Subject("dia", "Địa", R.drawable.ic_category)
        );

        subjectAdapter = new SubjectAdapter(subjectList, subject -> {
//             Xử lý khi click vào môn học, chuyển sang màn hình ôn tập/làm quiz
             Intent intent = new Intent(this, QuizActivity.class);
             intent.putExtra("subjectId", subject.getId());
             startActivity(intent);
        });

        rvSubjects.setLayoutManager(new LinearLayoutManager(this));
        rvSubjects.setAdapter(subjectAdapter);



    }
}
