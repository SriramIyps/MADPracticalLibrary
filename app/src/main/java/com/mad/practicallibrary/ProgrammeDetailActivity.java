package com.mad.practicallibrary;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.mad.practicallibrary.adapter.FileChipAdapter;
import com.mad.practicallibrary.model.Programme;
import com.mad.practicallibrary.model.SourceFile;
import com.mad.practicallibrary.repository.ProgrammeRepository;
import com.mad.practicallibrary.utils.ClipboardHelper;

import java.util.List;

public class ProgrammeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_PROGRAMME_NUMBER = "extra_programme_number";

    private ImageButton btnBack;
    private TextView tvDetailTitle;
    private TextView tvDetailPackage;
    private MaterialButton btnCopyAllFiles;
    private LinearLayout layoutNoticeBanner;
    private TextView tvNoticeText;
    private RecyclerView rvFileChips;
    private TextView tvCurrentFileName;
    private TextView tvCurrentFilePath;
    private ImageButton btnZoomIn;
    private ImageButton btnZoomOut;
    private MaterialButton btnCopyActiveFile;
    private NestedScrollView scrollCodeVertical;
    private TextView tvLineNumbers;
    private TextView tvCodeContent;

    private Programme programme;
    private SourceFile currentFile;
    private float currentCodeTextSizeSp = 13.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme_detail);

        int progNumber = getIntent().getIntExtra(EXTRA_PROGRAMME_NUMBER, 1);
        programme = ProgrammeRepository.getInstance().getProgrammeByNumber(progNumber);

        if (programme == null) {
            Toast.makeText(this, "Programme not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        initViews();
        populateHeader();
        setupFileChips();
        setupZoomControls();
        setupCopyButtons();
    }

    private void initViews() {
        btnBack = findViewById(R.id.btnBack);
        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvDetailPackage = findViewById(R.id.tvDetailPackage);
        btnCopyAllFiles = findViewById(R.id.btnCopyAllFiles);
        layoutNoticeBanner = findViewById(R.id.layoutNoticeBanner);
        tvNoticeText = findViewById(R.id.tvNoticeText);
        rvFileChips = findViewById(R.id.rvFileChips);
        tvCurrentFileName = findViewById(R.id.tvCurrentFileName);
        tvCurrentFilePath = findViewById(R.id.tvCurrentFilePath);
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomOut = findViewById(R.id.btnZoomOut);
        btnCopyActiveFile = findViewById(R.id.btnCopyActiveFile);
        scrollCodeVertical = findViewById(R.id.scrollCodeVertical);
        tvLineNumbers = findViewById(R.id.tvLineNumbers);
        tvCodeContent = findViewById(R.id.tvCodeContent);

        btnBack.setOnClickListener(v -> finish());
    }

    private void populateHeader() {
        tvDetailTitle.setText("Programme " + programme.getNumber() + ": " + programme.getTitle());
        tvDetailPackage.setText(programme.getPackageName());

        if (programme.getNotes() != null && !programme.getNotes().isEmpty()) {
            layoutNoticeBanner.setVisibility(View.VISIBLE);
            tvNoticeText.setText(programme.getNotes());
        } else {
            layoutNoticeBanner.setVisibility(View.GONE);
        }
    }

    private void setupFileChips() {
        List<SourceFile> files = programme.getSourceFiles();
        rvFileChips.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        FileChipAdapter adapter = new FileChipAdapter(files, (file, position) -> {
            displayFile(file);
        });
        rvFileChips.setAdapter(adapter);

        if (!files.isEmpty()) {
            displayFile(files.get(0));
        }
    }

    private void displayFile(SourceFile file) {
        this.currentFile = file;
        tvCurrentFileName.setText(file.getName());
        tvCurrentFilePath.setText(file.getProjectPath());

        String content = file.getContent(this);
        tvCodeContent.setText(content);

        // Calculate and render line numbers
        int lineCount = countLines(content);
        StringBuilder lineNumbersBuilder = new StringBuilder();
        for (int i = 1; i <= lineCount; i++) {
            lineNumbersBuilder.append(i).append("\n");
        }
        tvLineNumbers.setText(lineNumbersBuilder.toString());

        // Reset scroll position to top
        scrollCodeVertical.scrollTo(0, 0);
    }

    private int countLines(String str) {
        if (str == null || str.isEmpty()) return 1;
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\n') {
                count++;
            }
        }
        return count;
    }

    private void setupZoomControls() {
        btnZoomIn.setOnClickListener(v -> {
            if (currentCodeTextSizeSp < 22.0f) {
                currentCodeTextSizeSp += 1.5f;
                updateCodeTextSize();
            }
        });

        btnZoomOut.setOnClickListener(v -> {
            if (currentCodeTextSizeSp > 10.0f) {
                currentCodeTextSizeSp -= 1.5f;
                updateCodeTextSize();
            }
        });
    }

    private void updateCodeTextSize() {
        tvCodeContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentCodeTextSizeSp);
        tvLineNumbers.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentCodeTextSizeSp);
    }

    private void setupCopyButtons() {
        btnCopyActiveFile.setOnClickListener(v -> {
            if (currentFile != null) {
                String code = currentFile.getContent(this);
                ClipboardHelper.copyToClipboard(this, currentFile.getName(), code);
            }
        });

        btnCopyAllFiles.setOnClickListener(v -> {
            String allCode = programme.formatAllFilesForClipboard(this);
            ClipboardHelper.copyToClipboard(this, "Programme " + programme.getNumber() + " (All Files)", allCode);
        });
    }
}
