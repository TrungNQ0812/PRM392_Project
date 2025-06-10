package com.example.quizapp.ui.quiz.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {

    private List<String> answers;
    private int selectedPosition = -1;
    private OnAnswerSelectedListener listener;

    public interface OnAnswerSelectedListener {
        void onAnswerSelected(int position);
    }

    public AnswerAdapter(List<String> answers, OnAnswerSelectedListener listener) {
        this.answers = answers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(answers.get(position));
        holder.textView.setBackgroundColor(selectedPosition == position ? Color.parseColor("#1976D2") : Color.WHITE);
        holder.textView.setTextColor(selectedPosition == position ? Color.WHITE : Color.BLACK);
        holder.itemView.setOnClickListener(v -> {
            int prevSelected = selectedPosition;
            selectedPosition = position;
            notifyItemChanged(prevSelected);
            notifyItemChanged(selectedPosition);
            if (listener != null) listener.onAnswerSelected(position);
        });
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    public static class AnswerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }
}
