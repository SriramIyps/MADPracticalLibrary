package com.mad.practicallibrary.model;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SourceFile {
    private final String name;
    private final String assetPath;
    private final String projectPath;
    private final String fileType;
    private final boolean isExtra;
    private String cachedContent;

    public SourceFile(String name, String assetPath, String projectPath, String fileType, boolean isExtra) {
        this.name = name;
        this.assetPath = assetPath;
        this.projectPath = projectPath;
        this.fileType = fileType;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public String getFileType() {
        return fileType;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public String getContent(Context context) {
        if (cachedContent != null) {
            return cachedContent;
        }
        try {
            InputStream is = context.getAssets().open(assetPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();
            is.close();
            cachedContent = sb.toString();
        } catch (Exception e) {
            cachedContent = "// Error reading file from assets: " + e.getMessage();
        }
        return cachedContent;
    }
}
