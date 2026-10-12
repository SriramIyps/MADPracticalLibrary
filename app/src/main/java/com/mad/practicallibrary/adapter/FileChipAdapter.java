package com.mad.practicallibrary.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.mad.practicallibrary.R;
import com.mad.practicallibrary.model.SourceFile;

import java.util.List;

public class FileChipAdapter extends RecyclerView.Adapter<FileChipAdapter.FileChipViewHolder> {

    public interface OnFileSelectedListener {
        void onFileSelected(SourceFile file, int position);
    }

    private final List<SourceFile> files;
    private final OnFileSelectedListener listener;
    private int selectedPosition = 0;

    public FileChipAdapter(List<SourceFile> files, OnFileSelectedListener listener) {
        this.files = files;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FileChipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_chip, parent, false);
        return new FileChipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FileChipViewHolder holder, int position) {
        SourceFile file = files.get(position);
        Context context = holder.itemView.getContext();
        boolean isSelected = position == selectedPosition;

        holder.tvFileName.setText(file.getName());
        holder.tvFileType.setText(file.getFileType());

        // File icon
        if (file.getName().endsWith(".java")) {
            holder.tvFileIcon.setText("☕");
        } else if (file.getName().endsWith(".xml")) {
            if (file.getName().equals("AndroidManifest.xml")) {
                holder.tvFileIcon.setText("📋");
            } else if (file.getName().startsWith("menu_")) {
                holder.tvFileIcon.setText("📑");
            } else {
                holder.tvFileIcon.setText("📄");
            }
        } else {
            holder.tvFileIcon.setText("📁");
        }

        // Extra badge
        holder.tvExtraBadge.setVisibility(file.isExtra() ? View.VISIBLE : View.GONE);

        // Styling for selected vs unselected
        if (isSelected) {
            holder.cardFileChip.setCardBackgroundColor(ContextCompat.getColor(context, R.color.primary_light));
            holder.cardFileChip.setStrokeColor(ContextCompat.getColor(context, R.color.primary));
            holder.cardFileChip.setStrokeWidth(3);
            holder.tvFileName.setTextColor(ContextCompat.getColor(context, R.color.primary));
            holder.tvFileType.setTextColor(ContextCompat.getColor(context, R.color.primary_variant));
        } else {
            holder.cardFileChip.setCardBackgroundColor(ContextCompat.getColor(context, R.color.surface));
            holder.cardFileChip.setStrokeColor(ContextCompat.getColor(context, R.color.border));
            holder.cardFileChip.setStrokeWidth(1);
            holder.tvFileName.setTextColor(ContextCompat.getColor(context, R.color.text_primary));
            holder.tvFileType.setTextColor(ContextCompat.getColor(context, R.color.text_tertiary));
        }

        holder.itemView.setOnClickListener(v -> {
            int prevSelected = selectedPosition;
            selectedPosition = holder.getAdapterPosition();
            notifyItemChanged(prevSelected);
            notifyItemChanged(selectedPosition);
            if (listener != null) {
                listener.onFileSelected(file, selectedPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return files.size();
    }

    public void setSelectedPosition(int position) {
        int prev = selectedPosition;
        selectedPosition = position;
        notifyItemChanged(prev);
        notifyItemChanged(selectedPosition);
    }

    static class FileChipViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cardFileChip;
        LinearLayout layoutChipContent;
        TextView tvFileIcon, tvFileName, tvFileType, tvExtraBadge;

        public FileChipViewHolder(@NonNull View itemView) {
            super(itemView);
            cardFileChip = itemView.findViewById(R.id.cardFileChip);
            layoutChipContent = itemView.findViewById(R.id.layoutChipContent);
            tvFileIcon = itemView.findViewById(R.id.tvFileIcon);
            tvFileName = itemView.findViewById(R.id.tvFileName);
            tvFileType = itemView.findViewById(R.id.tvFileType);
            tvExtraBadge = itemView.findViewById(R.id.tvExtraBadge);
        }
    }
}
