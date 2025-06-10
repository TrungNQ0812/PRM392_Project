package com.example.quizapp.ui.student.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.entity.Subject;
import com.example.quizapp.ui.quiz.activity.QuizActivity;
import com.example.quizapp.ui.subject.adapter.SubjectAdapter;

import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rvSubjects;
    private SubjectAdapter subjectAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvSubjects = view.findViewById(R.id.rvSubjects);

        // Mock data
        List<Subject> subjectList = Arrays.asList(
                new Subject("toan", "Toán", R.drawable.ic_calculator),
                new Subject("ly", "Lý", R.drawable.ic_science),
                new Subject("hoa", "Hóa", R.drawable.ic_science),
                new Subject("su", "Sử", R.drawable.ic_history),
                new Subject("dia", "Địa", R.drawable.ic_category)
        );

        subjectAdapter = new SubjectAdapter(subjectList, subject -> {
            // Xử lý khi click vào môn học
            Intent intent = new Intent(getContext(), QuizActivity.class);
            intent.putExtra("subjectId", subject.getId());
            startActivity(intent);
        });

        rvSubjects.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSubjects.setAdapter(subjectAdapter);

        return view;
    }
}
