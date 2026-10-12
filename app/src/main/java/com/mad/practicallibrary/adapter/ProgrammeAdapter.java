package com.mad.practicallibrary.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.mad.practicallibrary.ProgrammeDetailActivity;
import com.mad.practicallibrary.R;
import com.mad.practicallibrary.model.Programme;
import com.mad.practicallibrary.model.SourceFile;
import com.mad.practicallibrary.utils.ClipboardHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProgrammeAdapter extends RecyclerView.Adapter<ProgrammeAdapter.ProgrammeViewHolder> implements Filterable {

    public interface OnListFilteredListener {
        void onListFiltered(int count);
    }

    private final List<Programme> originalList;
    private List<Programme> filteredList;
    private final OnListFilteredListener filterListener;

    public ProgrammeAdapter(List<Programme> list, OnListFilteredListener filterListener) {
        this.originalList = new ArrayList<>(list);
        this.filteredList = new ArrayList<>(list);
        this.filterListener = filterListener;
    }

    @NonNull
    @Override
    public ProgrammeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_programme, parent, false);
        return new ProgrammeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammeViewHolder holder, int position) {
        Programme programme = filteredList.get(position);
        Context context = holder.itemView.getContext();

        holder.tvProgrammeNumber.setText(programme.getFormattedNumber());
        holder.tvProgrammeTitle.setText("Programme " + programme.getNumber() + ": " + programme.getTitle());
        holder.tvPackageName.setText(programme.getPackageName());
        holder.tvProgrammeDesc.setText(programme.getDescription());

        // Files count summary
        int totalFiles = programme.getSourceFiles().size();
        holder.tvFilesCount.setText(totalFiles + " files (Java, XML, Manifest)");

        // Warning badge for App 6 and App 8
        if (programme.getNumber() == 6 || programme.getNumber() == 8) {
            holder.tvWarningBadge.setVisibility(View.VISIBLE);
            if (programme.getNumber() == 6) {
                holder.tvWarningBadge.setText("⚠️ Note: 'new6' Activity undeclared in Manifest + 2 extra files");
            } else {
                holder.tvWarningBadge.setText("ℹ️ Note: Includes original draft menus + stub new6.java");
            }
        } else if (programme.getNumber() == 4) {
            holder.tvWarningBadge.setVisibility(View.VISIBLE);
            holder.tvWarningBadge.setText("ℹ️ Note: Uses ProgressDialog (deprecated API 26)");
        } else {
            holder.tvWarningBadge.setVisibility(View.GONE);
        }

        // Click on whole card or Open Code button
        View.OnClickListener openDetail = v -> {
            Intent intent = new Intent(context, ProgrammeDetailActivity.class);
            intent.putExtra(ProgrammeDetailActivity.EXTRA_PROGRAMME_NUMBER, programme.getNumber());
            context.startActivity(intent);
        };
        holder.cardProgramme.setOnClickListener(openDetail);
        holder.btnOpenProgramme.setOnClickListener(openDetail);

        // Quick Copy All Button on card
        holder.btnQuickCopyAll.setOnClickListener(v -> {
            String allCode = programme.formatAllFilesForClipboard(context);
            ClipboardHelper.copyToClipboard(context, "Programme " + programme.getNumber() + " (All Files)", allCode);
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                if (constraint == null || constraint.toString().trim().isEmpty()) {
                    results.values = originalList;
                    results.count = originalList.size();
                } else {
                    String query = constraint.toString().trim().toLowerCase(Locale.getDefault());
                    List<Programme> filtered = new ArrayList<>();
                    for (Programme p : originalList) {
                        if (String.valueOf(p.getNumber()).equals(query)
                                || p.getFormattedNumber().equals(query)
                                || p.getTitle().toLowerCase(Locale.getDefault()).contains(query)
                                || p.getDescription().toLowerCase(Locale.getDefault()).contains(query)
                                || p.getPackageName().toLowerCase(Locale.getDefault()).contains(query)) {
                            filtered.add(p);
                            continue;
                        }
                        for (SourceFile sf : p.getSourceFiles()) {
                            if (sf.getName().toLowerCase(Locale.getDefault()).contains(query)) {
                                filtered.add(p);
                                break;
                            }
                        }
                    }
                    results.values = filtered;
                    results.count = filtered.size();
                }
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (List<Programme>) results.values;
                notifyDataSetChanged();
                if (filterListener != null) {
                    filterListener.onListFiltered(filteredList.size());
                }
            }
        };
    }

    static class ProgrammeViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cardProgramme;
        TextView tvProgrammeNumber, tvProgrammeTitle, tvPackageName, tvProgrammeDesc, tvFilesCount, tvWarningBadge;
        MaterialButton btnOpenProgramme;
        ImageButton btnQuickCopyAll;

        public ProgrammeViewHolder(@NonNull View itemView) {
            super(itemView);
            cardProgramme = itemView.findViewById(R.id.cardProgramme);
            tvProgrammeNumber = itemView.findViewById(R.id.tvProgrammeNumber);
            tvProgrammeTitle = itemView.findViewById(R.id.tvProgrammeTitle);
            tvPackageName = itemView.findViewById(R.id.tvPackageName);
            tvProgrammeDesc = itemView.findViewById(R.id.tvProgrammeDesc);
            tvFilesCount = itemView.findViewById(R.id.tvFilesCount);
            tvWarningBadge = itemView.findViewById(R.id.tvWarningBadge);
            btnOpenProgramme = itemView.findViewById(R.id.btnOpenProgramme);
            btnQuickCopyAll = itemView.findViewById(R.id.btnQuickCopyAll);
        }
    }
}
