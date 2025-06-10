package com.example.quizapp.entity;

public class User {
    private String username, fullName, email, role, dob, gender, studentClass;

    public User(String username, String fullName, String email, String role,
                String dob, String gender, String studentClass) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.dob = dob;
        this.gender = gender;
        this.studentClass = studentClass;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getStudentClass() {
        return studentClass;
    }
}
