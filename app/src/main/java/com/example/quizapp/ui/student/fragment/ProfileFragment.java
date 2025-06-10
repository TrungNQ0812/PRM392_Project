package com.example.quizapp.ui.student.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quizapp.R;
import com.example.quizapp.entity.User;

public class ProfileFragment extends Fragment {

    private ImageView imgAvatar;
    private TextView tvFullName, tvUsername, tvEmail, tvRole, tvDob, tvGender, tvClass;
    private Button btnEditProfile, btnLogout;

    // Mock: thông tin user (sau này lấy từ login/session hoặc SharedPreferences)
    private User mockUser = new User(
            "student01",
            "Nguyễn Văn A",
            "student01@gmail.com",
            "student",
            "20/10/2005",
            "Nam",
            "10"
    );

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imgAvatar = view.findViewById(R.id.imgAvatar);
        tvFullName = view.findViewById(R.id.tvFullName);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvRole = view.findViewById(R.id.tvRole);
        tvDob = view.findViewById(R.id.tvDob);
        tvGender = view.findViewById(R.id.tvGender);
        tvClass = view.findViewById(R.id.tvClass);
        btnEditProfile = view.findViewById(R.id.btnEditProfile);
        btnLogout = view.findViewById(R.id.btnLogout);

        // Hiển thị thông tin
        tvFullName.setText(mockUser.getFullName());
        tvUsername.setText("Username: " + mockUser.getUsername());
        tvEmail.setText("Email: " + mockUser.getEmail());
        tvRole.setText("Loại tài khoản: " + (mockUser.getRole().equals("student") ? "Học sinh" : "Giáo viên"));

        if (mockUser.getRole().equals("student")) {
            tvDob.setText("Ngày sinh: " + mockUser.getDob());
            tvGender.setText("Giới tính: " + mockUser.getGender());
            tvClass.setText("Lớp: " + mockUser.getStudentClass());
            tvDob.setVisibility(View.VISIBLE);
            tvGender.setVisibility(View.VISIBLE);
            tvClass.setVisibility(View.VISIBLE);
        } else {
            tvDob.setVisibility(View.GONE);
            tvGender.setVisibility(View.GONE);
            tvClass.setVisibility(View.GONE);
        }

        btnEditProfile.setOnClickListener(view1 -> {
            // Xử lý chuyển sang màn hình chỉnh sửa profile (nếu có)
        });

        btnLogout.setOnClickListener(view1 -> {
            requireActivity().finish();
        });

        return view;
    }


}
