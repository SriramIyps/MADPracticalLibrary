package com.madlibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammeDetails implements Serializable {
    private final int number;
    private final String title;
    private final String description;
    private final String packageName;
    private final String notes;
    private final List<SourceFileDetails> files;

    public ProgrammeDetails(int number, String title, String description, String packageName, String notes, List<SourceFileDetails> files) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.packageName = packageName;
        this.notes = notes;
        this.files = new ArrayList<>(files);
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

    public List<SourceFileDetails> getFiles() {
        return Collections.unmodifiableList(files);
    }

    public List<String> getFileNames() {
        List<String> names = new ArrayList<>();
        for (SourceFileDetails f : files) {
            names.add(f.getName());
        }
        return names;
    }

    @Override
    public String toString() {
        return "Programme " + number + ": " + title + " (" + files.size() + " files)";
    }
}
