package com.example.quizapp.ui.auth.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizapp.R;
import com.example.quizapp.ui.student.activity.StudentHomeActivity;
import com.example.quizapp.ui.subject.activity.SubjectListActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onRegisterClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void onLoginClick(View view) {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            // Hiển thị thông báo lỗi nếu thông tin đăng nhập không hợp lệ
            edtUsername.setError("Vui lòng nhập tên đăng nhập");
            edtPassword.setError("Vui lòng nhập mật khẩu");
            return;
        }

        // logic login
        // mock data cho hoc sinh va giáo viên
        if (username.equals("student") && password.equals("123456")) {
            Intent intent = new Intent(this, StudentHomeActivity.class);
            startActivity(intent);
        } else if (username.equals("teacher") && password.equals("123456")) {
            Toast.makeText(this, "Đăng nhập thành công với tư cách giáo viên", Toast.LENGTH_SHORT).show();
        } else {
            // Hiển thị thông báo lỗi nếu thông tin đăng nhập không đúng
            edtUsername.setError("Tên đăng nhập hoặc mật khẩu không đúng");
            edtPassword.setError("Tên đăng nhập hoặc mật khẩu không đúng");
        }
    }
}