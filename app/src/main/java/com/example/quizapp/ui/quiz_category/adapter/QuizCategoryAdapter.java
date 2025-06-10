package com.example.quizapp.ui.quiz_category.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.entity.QuizCategory;

import java.util.List;

public class QuizCategoryAdapter extends RecyclerView.Adapter<QuizCategoryAdapter.QuizViewHolder> {

    private List<QuizCategory> list;
    private OnQuizClickListener listener;

    public interface OnQuizClickListener {
        void onQuizClick(QuizCategory category);
    }

    public QuizCategoryAdapter(List<QuizCategory> list, OnQuizClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz, parent, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        QuizCategory category = list.get(position);
        holder.tvTitle.setText(category.getTitle());
        holder.tvDesc.setText(category.getDescription());
        holder.imgIcon.setImageResource(category.getIconResId());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onQuizClick(category);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class QuizViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView tvTitle, tvDesc;

        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgQuizIcon);
            tvTitle = itemView.findViewById(R.id.tvQuizTitle);
            tvDesc = itemView.findViewById(R.id.tvQuizDesc);
        }
    }
}
