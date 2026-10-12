package com.mad.practicallibrary;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mad.practicallibrary.adapter.ProgrammeAdapter;
import com.mad.practicallibrary.model.Programme;
import com.mad.practicallibrary.repository.ProgrammeRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etSearch;
    private ImageButton btnClearSearch;
    private ImageButton btnAppInfo;
    private TextView tvStatsSummary;
    private RecyclerView rvProgrammes;
    private LinearLayout layoutEmptyState;
    private ProgrammeAdapter adapter;
    private List<Programme> programmeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupRecyclerView();
        setupSearch();
        setupInfoDialog();
    }

    private void initViews() {
        etSearch = findViewById(R.id.etSearch);
        btnClearSearch = findViewById(R.id.btnClearSearch);
        btnAppInfo = findViewById(R.id.btnAppInfo);
        tvStatsSummary = findViewById(R.id.tvStatsSummary);
        rvProgrammes = findViewById(R.id.rvProgrammes);
        layoutEmptyState = findViewById(R.id.layoutEmptyState);
    }

    private void setupRecyclerView() {
        programmeList = ProgrammeRepository.getInstance().getAllProgrammes();
        adapter = new ProgrammeAdapter(programmeList, count -> {
            if (count == 0) {
                layoutEmptyState.setVisibility(View.VISIBLE);
                rvProgrammes.setVisibility(View.GONE);
                tvStatsSummary.setText("No practicals found");
            } else {
                layoutEmptyState.setVisibility(View.GONE);
                rvProgrammes.setVisibility(View.VISIBLE);
                tvStatsSummary.setText("Showing " + count + " of 10 Practicals");
            }
        });

        rvProgrammes.setLayoutManager(new LinearLayoutManager(this));
        rvProgrammes.setAdapter(adapter);
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString();
                btnClearSearch.setVisibility(query.isEmpty() ? View.GONE : View.VISIBLE);
                adapter.getFilter().filter(query);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        btnClearSearch.setOnClickListener(v -> {
            etSearch.setText("");
            btnClearSearch.setVisibility(View.GONE);
        });
    }

    private void setupInfoDialog() {
        btnAppInfo.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("MAD Practical Library")
                    .setMessage(
                            "Welcome to the Mobile Application Development (MAD) Practical Library!\n\n"
                                    + "Features:\n"
                                    + "• 10 complete practical programmes from MyApplication1 to MyApplication10\n"
                                    + "• Open and view any Java, XML layout, AndroidManifest.xml, and resource file\n"
                                    + "• Copy individual source files directly to your clipboard\n"
                                    + "• Copy all files of any practical in one click with clear file separators\n"
                                    + "• Instant search by practical number (1-10), title, or file name\n\n"
                                    + "Original Projects Notes:\n"
                                    + "• Programme 6: Note that 'new6' Activity was not registered in the original AndroidManifest.xml. Add <activity android:name=\".new6\" /> to run without crashing.\n"
                                    + "• Programmes 6 & 8: All original draft/extra files have been preserved verbatim."
                    )
                    .setPositiveButton("Got it", null)
                    .show();
        });
    }
}
