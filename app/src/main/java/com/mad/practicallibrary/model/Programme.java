package com.mad.practicallibrary.model;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class Programme {
    private final int number;
    private final String title;
    private final String description;
    private final String packageName;
    private final String notes;
    private final List<SourceFile> sourceFiles;

    public Programme(int number, String title, String description, String packageName, String notes) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.packageName = packageName;
        this.notes = notes;
        this.sourceFiles = new ArrayList<>();
    }

    public void addSourceFile(SourceFile file) {
        sourceFiles.add(file);
    }

    public int getNumber() {
        return number;
    }

    public String getFormattedNumber() {
        return String.format("%02d", number);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getNotes() {
        return notes;
    }

    public List<SourceFile> getSourceFiles() {
        return sourceFiles;
    }

    public String formatAllFilesForClipboard(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("================================================================================\n");
        sb.append("PROGRAMME ").append(number).append(": ").append(title.toUpperCase()).append("\n");
        sb.append("Package: ").append(packageName).append("\n");
        if (notes != null && !notes.isEmpty()) {
            sb.append("Note: ").append(notes).append("\n");
        }
        sb.append("Total Files: ").append(sourceFiles.size()).append("\n");
        sb.append("================================================================================\n\n");

        for (int i = 0; i < sourceFiles.size(); i++) {
            SourceFile file = sourceFiles.get(i);
            sb.append("--------------------------------------------------------------------------------\n");
            sb.append("FILE [").append(i + 1).append("/").append(sourceFiles.size()).append("]: ").append(file.getName()).append("\n");
            sb.append("TYPE: ").append(file.getFileType()).append(file.isExtra() ? " (Original Extra File)" : "").append("\n");
            sb.append("STUDIO PATH: ").append(file.getProjectPath()).append("\n");
            sb.append("--------------------------------------------------------------------------------\n");
            sb.append(file.getContent(context));
            sb.append("\n\n");
        }

        return sb.toString();
    }
}
