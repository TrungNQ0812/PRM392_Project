package com.example.quizapp.ui.auth.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizapp.R;
import com.example.quizapp.ui.subject.activity.SubjectListActivity;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText edtFullName;
    private TextInputEditText edtUsername;
    private TextInputEditText edtEmail;
    private TextInputEditText edtPassword;
    private TextInputEditText edtConfirmPassword;
    private RadioGroup rgUserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void registerUser(View view) {
        // Lấy thông tin từ các trường nhập liệu
        edtFullName = findViewById(R.id.edtFullName);
        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        rgUserType = findViewById(R.id.rgUserType);
        String fullName = edtFullName.getText().toString();
        String username = edtUsername.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String confirmPassword = edtConfirmPassword.getText().toString();
        int selectedUserType = rgUserType.getCheckedRadioButtonId();

        if (fullName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            // Hiển thị thông báo lỗi nếu có trường nào đó để trống
            if (fullName.isEmpty()) edtFullName.setError("Vui lòng nhập họ tên");
            if (username.isEmpty()) edtUsername.setError("Vui lòng nhập tên đăng nhập");
            if (email.isEmpty()) edtEmail.setError("Vui lòng nhập email");
            if (password.isEmpty()) edtPassword.setError("Vui lòng nhập mật khẩu");
            if (confirmPassword.isEmpty())
                edtConfirmPassword.setError("Vui lòng xác nhận mật khẩu");
            return;
        }

        if (!password.equals(confirmPassword)) {
            edtConfirmPassword.setError("Mật khẩu không khớp");
            return;
        }


//        if (selectedUserType == R.id.rbStudent) {
//            Intent intent = new Intent(this, SubjectListActivity.class);
//            intent.putExtra("userType", "student");
//            intent.putExtra("fullName", fullName);
//            intent.putExtra("username", username);
//            intent.putExtra("email", email);
//            intent.putExtra("password", password);
//            intent.putExtra("type", "student");
//            startActivity(intent);
//
//        }

        if (selectedUserType == R.id.rbStudent) {
            View dialogView = getLayoutInflater().inflate(R.layout.activity_student_register_info, null);

            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Student Information")
                    .setView(dialogView)
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        }
    }
}